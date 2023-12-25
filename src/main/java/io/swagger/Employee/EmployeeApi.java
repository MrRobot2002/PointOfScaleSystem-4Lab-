/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.51).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.Employee;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@Validated
public interface EmployeeApi {

    @Operation(summary = "Delete a specific employee", description = "Deletes a specific employee from the system.", security = {
            @SecurityRequirement(name = "BearerAuth") }, tags = { "Employee" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Employee successfully deleted"),

            @ApiResponse(responseCode = "404", description = "Employee not found") })
    @RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteEmployee(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("employeeId") Long employeeId);

    @Operation(summary = "Retrieve a specific employee", description = "Retrieves details of a specific employee by ID.", security = {
            @SecurityRequirement(name = "BearerAuth") }, tags = { "Employee" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee details", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class))),

            @ApiResponse(responseCode = "404", description = "Employee not found") })
    @RequestMapping(value = "/employee/{employeeId}", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<Employee> getEmployee(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("employeeId") Long employeeId);

    @Operation(summary = "Register new employee", description = "Registers a new employee to the POS system.", security = {
            @SecurityRequirement(name = "BearerAuth") }, tags = { "Employee" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee registered"),

            @ApiResponse(responseCode = "400", description = "Invalid input") })
    @RequestMapping(value = "/employee", consumes = { "application/json" }, method = RequestMethod.POST)
    ResponseEntity<Employee> createEmployee(
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody CreateEmployee body);

    @Operation(summary = "Update a specific employee's role", description = "Updates the role of a specific employee. Restricted to managers and system administrators.", security = {
            @SecurityRequirement(name = "BearerAuth") }, tags = { "Employee" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee role updated"),

            @ApiResponse(responseCode = "400", description = "Invalid input"),

            @ApiResponse(responseCode = "404", description = "Employee not found") })
    @RequestMapping(value = "/employee/{employeeId}", consumes = { "application/json" }, method = RequestMethod.PUT)
    ResponseEntity<Employee> updateEmployee(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("employeeId") Long employeeId,
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody CreateEmployee body);

}
