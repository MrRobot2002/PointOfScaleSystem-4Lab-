/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.51).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Product;
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
public interface InventoryApi {

    @Operation(summary = "Add a new product to the inventory", description = "Allows the addition of a new product to the inventory.", security = {
        @SecurityRequirement(name = "BearerAuth")    }, tags={ "Inventory" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Product successfully added to the inventory", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid input") })
    @RequestMapping(value = "/inventory/add-product",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Product> addProduct(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Product body
);


    @Operation(summary = "Remove a product from the inventory", description = "Deletes a specific product from the inventory by ID.", security = {
        @SecurityRequirement(name = "BearerAuth")    }, tags={ "Inventory" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Product successfully deleted"),
        
        @ApiResponse(responseCode = "404", description = "Product not found") })
    @RequestMapping(value = "/inventory/products/{productId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteProduct(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("productId") Long productId
);


    @Operation(summary = "View specific product details", description = "Retrieves details of a specific product by ID.", security = {
        @SecurityRequirement(name = "BearerAuth")    }, tags={ "Inventory" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Detailed product information", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))),
        
        @ApiResponse(responseCode = "404", description = "Product not found") })
    @RequestMapping(value = "/inventory/products/{productId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Product> getProduct(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("productId") Long productId
);


    @Operation(summary = "List all products in the inventory", description = "Retrieves a list of all products in the inventory.", security = {
        @SecurityRequirement(name = "BearerAuth")    }, tags={ "Inventory" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A list of products in Inventory", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Product.class)))) })
    @RequestMapping(value = "/inventory/products",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Product>> listAllProducts(@Parameter(in = ParameterIn.QUERY, description = "Filter by product category" ,schema=@Schema()) @Valid @RequestParam(value = "category", required = false) String category
, @Parameter(in = ParameterIn.QUERY, description = "Filter by price range (0-50, 50-100 etc.)" ,schema=@Schema()) @Valid @RequestParam(value = "priceRange", required = false) String priceRange
, @Parameter(in = ParameterIn.QUERY, description = "Filter by stock level" ,schema=@Schema()) @Valid @RequestParam(value = "stockLevel", required = false) Integer stockLevel
);


    @Operation(summary = "Update specific attributes of a product", description = "Updates specific attributes of a product by ID.", security = {
        @SecurityRequirement(name = "BearerAuth")    }, tags={ "Inventory" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Specific product attributes updated"),
        
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        
        @ApiResponse(responseCode = "404", description = "Product not found") })
    @RequestMapping(value = "/inventory/products/{productId}",
        consumes = { "application/json" }, 
        method = RequestMethod.PATCH)
    ResponseEntity<Void> patchProduct(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("productId") Long productId
, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Product body
);


    @Operation(summary = "Update details of an existing product", description = "Updates details of an existing product by ID.", security = {
        @SecurityRequirement(name = "BearerAuth")    }, tags={ "Inventory" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Product details successfully updated"),
        
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        
        @ApiResponse(responseCode = "404", description = "Product not found") })
    @RequestMapping(value = "/inventory/products/{productId}",
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateProduct(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("productId") Long productId
, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Product body
);

}

