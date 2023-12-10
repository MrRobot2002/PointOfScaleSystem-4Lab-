/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.51).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.User;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-10T17:29:46.806586+02:00[Europe/Vilnius]")
@Validated
public interface CustomersApi {

    @Operation(summary = "Create a new user", description = "Creates a new customer in the POS system.", security = {
        @SecurityRequirement(name = "BearerAuth")    }, tags={ "Customers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "User created successfully"),
        
        @ApiResponse(responseCode = "400", description = "Invalid input") })
    @RequestMapping(value = "/customers",
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> createCustomer(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody User body
);


    @Operation(summary = "Remove a customer", description = "Removes a customer from the POS system.", security = {
        @SecurityRequirement(name = "BearerAuth")    }, tags={ "Customers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Customer removed successfully"),
        
        @ApiResponse(responseCode = "404", description = "Customer not found") })
    @RequestMapping(value = "/customers/{userId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteCustomer(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("userId") Long userId
);


    @Operation(summary = "Retrieve details of a specific customer", description = "Retrieves details of a specific customer by ID.", security = {
        @SecurityRequirement(name = "BearerAuth")    }, tags={ "Customers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Customer details", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
        
        @ApiResponse(responseCode = "404", description = "Customer not found") })
    @RequestMapping(value = "/customers/{userId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<User> getCustomer(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("userId") Long userId
);


    @Operation(summary = "List all customers", description = "Retrieves a list of all customers in the POS system.", security = {
        @SecurityRequirement(name = "BearerAuth")    }, tags={ "Customers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A list of customers", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = User.class)))) })
    @RequestMapping(value = "/customers",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<User>> listCustomers(@Parameter(in = ParameterIn.QUERY, description = "Filter discounts by category" ,schema=@Schema()) @Valid @RequestParam(value = "category", required = false) String category
);


    @Operation(summary = "Update a customers's details", description = "Updates a customers's details, including their role.", security = {
        @SecurityRequirement(name = "BearerAuth")    }, tags={ "Customers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Customer updated successfully"),
        
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        
        @ApiResponse(responseCode = "404", description = "Customer not found") })
    @RequestMapping(value = "/customers/{userId}",
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateUser(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("userId") Long userId
, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody User body
);

}

