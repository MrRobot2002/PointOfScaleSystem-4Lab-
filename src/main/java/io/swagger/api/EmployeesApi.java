/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.51).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Employee;
import io.swagger.model.EmployeeRoleUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-24T22:29:17.594034+02:00[Europe/Vilnius]")
@Validated
public interface EmployeesApi {

    @Operation(summary = "Delete a specific employee", description = "Deletes a specific employee from the system.", security = {
        @SecurityRequirement(name = "BearerAuth")    }, tags={ "Employees" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Employee successfully deleted"),
        
        @ApiResponse(responseCode = "404", description = "Employee not found") })
    @RequestMapping(value = "/employees/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteEmployee(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id") Long id
);


    @Operation(summary = "Retrieve a specific employee", description = "Retrieves details of a specific employee by ID.", security = {
        @SecurityRequirement(name = "BearerAuth")    }, tags={ "Employees" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Employee details", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class))),
        
        @ApiResponse(responseCode = "404", description = "Employee not found") })
    @RequestMapping(value = "/employees/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Employee> getEmployee(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id") Long id
);


    @Operation(summary = "Register new employee", description = "Registers a new employee to the POS system.", security = {
        @SecurityRequirement(name = "BearerAuth")    }, tags={ "Employees" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Employee registered"),
        
        @ApiResponse(responseCode = "400", description = "Invalid input") })
    @RequestMapping(value = "/employees",
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> registerEmployee(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Employee body
);


    @Operation(summary = "Update a specific employee's role", description = "Updates the role of a specific employee. Restricted to managers and system administrators.", security = {
        @SecurityRequirement(name = "BearerAuth")    }, tags={ "Employees" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Employee role updated"),
        
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        
        @ApiResponse(responseCode = "404", description = "Employee not found") })
    @RequestMapping(value = "/employees/{id}",
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateEmployeeRole(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id") Long id
, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody EmployeeRoleUpdate body
);

}

