/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.51).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.Product;

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
public interface ProductApi {

    @Operation(summary = "Add a new product to the inventory", description = "Allows the addition of a new product to the inventory.", security = {
            @SecurityRequirement(name = "BearerAuth") }, tags = { "Product" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product successfully added to the inventory", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))),

            @ApiResponse(responseCode = "400", description = "Invalid input") })
    @RequestMapping(value = "/product", produces = { "application/json" }, consumes = {
            "application/json" }, method = RequestMethod.POST)
    ResponseEntity<Product> createProduct(
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody CreateProduct body);


    @Operation(summary = "Remove a product from the inventory", description = "Deletes a specific product from the inventory by ID.", security = {
            @SecurityRequirement(name = "BearerAuth") }, tags = { "Product" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product successfully deleted"),

            @ApiResponse(responseCode = "404", description = "Product not found") })
    @RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE)
    ResponseEntity<Product> deleteProduct(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("productId") Long productId);

    @Operation(summary = "View specific product details", description = "Retrieves details of a specific product by ID.", security = {
            @SecurityRequirement(name = "BearerAuth") }, tags = { "Product" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detailed product information", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))),

            @ApiResponse(responseCode = "404", description = "Product not found") })
    @RequestMapping(value = "/product/{productId}", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<Product> getProduct(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("productId") Long productId);

    @Operation(summary = "Update details of an existing product", description = "Updates details of an existing product by ID.", security = {
            @SecurityRequirement(name = "BearerAuth") }, tags = { "Product" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product details successfully updated"),

            @ApiResponse(responseCode = "400", description = "Invalid input"),

            @ApiResponse(responseCode = "404", description = "Product not found") })
    @RequestMapping(value = "/product/{productId}", consumes = { "application/json" }, method = RequestMethod.PUT)
    ResponseEntity<Product> updateProduct(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("productId") Long productId,
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Product body);
}
