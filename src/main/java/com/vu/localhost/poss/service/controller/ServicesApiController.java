package com.vu.localhost.poss.service.controller;

import com.vu.localhost.poss.employee.service.EmployeeService;
import com.vu.localhost.poss.service.model.CreateServiceBooking.StatusEnum;
import com.vu.localhost.poss.service.model.Service;
import com.vu.localhost.poss.service.service.ServiceService;
import com.vu.localhost.poss.employee.model.EmployeeAvailability;
import com.vu.localhost.poss.employee.service.EmployeeAvailabilityService;
import com.vu.localhost.poss.employee.service.EmployeeServicesService;
import com.vu.localhost.poss.service.model.ServiceBooking;
import com.vu.localhost.poss.service.service.ServiceBookingService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@RestController
public class ServicesApiController implements ServicesApi {

    private static final Logger logger = LoggerFactory.getLogger(ServicesApiController.class);


    private final ServiceService serviceService;
    private final ServiceBookingService bookingService;
    private final EmployeeAvailabilityService employeeAvailabilityService;
    private final EmployeeServicesService employeeServicesService;
    private final EmployeeService employeeService;

    @org.springframework.beans.factory.annotation.Autowired
    public ServicesApiController(ServiceService serviceService, ServiceBookingService bookingService,
            EmployeeAvailabilityService employeeAvailabilityService, EmployeeServicesService employeeServicesService,
            EmployeeService employeeService) {
        this.serviceService = serviceService;
        this.bookingService = bookingService;
        this.employeeAvailabilityService = employeeAvailabilityService;
        this.employeeServicesService = employeeServicesService;
        this.employeeService = employeeService;
    }

    public ResponseEntity<Void> cancelServiceBooking(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("bookingId") Long bookingId) {

        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServiceBooking> getServiceBookingDetails(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("bookingId") Long bookingId) {

        return new ResponseEntity<ServiceBooking>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<Service>> listServices() {
        try {
            // Use the CustomerService to get all customers
            List<Service> services = serviceService.getAllServices();
            // Check if the customer list is empty
            if (services.isEmpty()) {
                // Return no content if there are no customers
                return ResponseEntity.noContent().build();
            }
            // Return the list of customers with an OK status
            return ResponseEntity.ok(services);
        } catch (Exception e) {
            // Log and return an Internal Server Error if something goes wrong
            System.err.println("Error occurred while trying to list customers: " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @Override
    public ResponseEntity<List<ServiceBooking>> listServiceBookings(Long serviceId, Long customerId, Long employeeId,
            Boolean availability, LocalDateTime from,
            LocalDateTime to) {
        LocalDateTime startTime = (from != null) ? from : LocalDateTime.now();
        LocalDateTime endTime = (to != null) ? to : startTime.plusYears(1);

        List<Long> serviceIds = serviceId != null ? Collections.singletonList(serviceId)
                : serviceService.getAllServiceIdsByTenantId(1L);
        List<Long> employeeIds = employeeId != null ? Collections.singletonList(employeeId)
                : employeeService.getAllEmployeesIdsByTenantId(1L);

        List<ServiceBooking> existingBookings = bookingService.getBookingsForEmployees(employeeIds, startTime, endTime);
        List<ServiceBooking> potentialBookings = new ArrayList<>();

        // Generate potential bookings only if availability is true or null
        if (availability == null || availability) {
            List<EmployeeAvailability> availabilities = employeeAvailabilityService.getAvailabilities(startTime, endTime, employeeIds);
            for (Long currentServiceId : serviceIds) {
                potentialBookings.addAll(generatePotentialBookingsForService(availabilities, currentServiceId, existingBookings));
            }
        }

        List<ServiceBooking> combinedBookings = new ArrayList<>();
        if (availability == null) { // Include both potential and existing bookings if availability is null
            combinedBookings.addAll(potentialBookings);
            combinedBookings.addAll(existingBookings);
        } else if (availability) { // Include only potential bookings if availability is true
            combinedBookings.addAll(potentialBookings);
        } else { // Include only existing bookings if availability is false
            combinedBookings.addAll(existingBookings);
        }

        return ResponseEntity.ok(combinedBookings);
    }

    private List<ServiceBooking> generatePotentialBookingsForService(List<EmployeeAvailability> availabilities,
            Long serviceId, List<ServiceBooking> existingBookings) {
        List<ServiceBooking> potentialBookings = new ArrayList<>();
        Duration serviceDuration = Duration.ofMinutes(serviceService.getServiceDuration(serviceId));

        for (EmployeeAvailability availability : availabilities) {
            if (employeeServicesService.isEmployeeAssignedToService(availability.getEmployeeId(), serviceId)) {
                potentialBookings.addAll(
                        createBookingsForAvailability(availability, serviceId, serviceDuration, existingBookings));
            }
        }

        return potentialBookings;
    }

    private List<ServiceBooking> createBookingsForAvailability(EmployeeAvailability availability, Long serviceId,
            Duration serviceDuration, List<ServiceBooking> existingBookings) {
        List<ServiceBooking> bookings = new ArrayList<>();
        LocalDateTime slotStart = availability.getStartTime();

        while (slotStart.plus(serviceDuration).isBefore(availability.getEndTime())
                || slotStart.plus(serviceDuration).isEqual(availability.getEndTime())) {
            LocalDateTime slotEnd = slotStart.plus(serviceDuration);
            LocalDateTime finalSlotStart = slotStart;
            boolean isOverlapping = existingBookings.stream()
                    .anyMatch(booking -> finalSlotStart.isBefore(booking.getEndTime())
                            && slotEnd.isAfter(booking.getStartTime()));

            if (!isOverlapping) {
                ServiceBooking potentialBooking = new ServiceBooking();
                potentialBooking.setStartTime(slotStart);
                potentialBooking.setEndTime(slotEnd);
                potentialBooking.setEmployeeId(availability.getEmployeeId());
                potentialBooking.setServiceId(serviceId);
                potentialBooking.setServiceStatus(StatusEnum.FREE.getOrdinal());

                bookings.add(potentialBooking);
            }
            slotStart = slotEnd;
        }

        return bookings;
    }

    public ResponseEntity<Void> updateServiceBooking(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("bookingId") Long bookingId,
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody ServiceBooking body) {

        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}