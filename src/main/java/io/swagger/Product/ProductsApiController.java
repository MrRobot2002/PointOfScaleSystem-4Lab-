package io.swagger.Product;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductsApiController implements ProductsApi {

    private static final Logger log = LoggerFactory.getLogger(ProductsApiController.class);

    private final ProductService productService;

    @Autowired
    public ProductsApiController(ProductService productService) {
        this.productService = productService;
    }

    public ResponseEntity<List<Product>> listAllProducts(
<<<<<<< HEAD
            @Parameter(in = ParameterIn.QUERY, description = "First element to show (pagination)", schema = @Schema()) @Valid @RequestParam(value = "from", required = false) Long from,
            @Parameter(in = ParameterIn.QUERY, description = "Last element to show (pagination)", schema = @Schema()) @Valid @RequestParam(value = "to", required = false) Long to,
=======
            @Parameter(in = ParameterIn.QUERY, description = "Page number (pagination)", schema = @Schema()) @Valid @RequestParam(value = "page", required = false) Integer page,
            @Parameter(in = ParameterIn.QUERY, description = "Page size (pagination)", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit,
>>>>>>> 02b85579cedf445c0ddc9e7d6c14716460bcd653
            @Parameter(in = ParameterIn.QUERY, description = "Filter by price range", schema = @Schema()) @Valid @RequestParam(value = "priceFrom", required = false) Double priceFrom,
            @Parameter(in = ParameterIn.QUERY, description = "Filter by price range", schema = @Schema()) @Valid @RequestParam(value = "priceTo", required = false) Double priceTo,
            @Parameter(in = ParameterIn.QUERY, description = "Filter by stock level", schema = @Schema()) @Valid @RequestParam(value = "quantityFrom", required = false) Long quantityFrom,
            @Parameter(in = ParameterIn.QUERY, description = "Filter by stock level", schema = @Schema()) @Valid @RequestParam(value = "quantityTo", required = false) Long quantityTo) {
        try {
            // Assuming there's a method in ProductService that returns all products
<<<<<<< HEAD
            List<Product> products = productService.getAllProducts(from, to, priceFrom, priceTo, quantityFrom,
=======
            List<Product> products = productService.getAllProducts(page, limit, priceFrom, priceTo, quantityFrom,
>>>>>>> 02b85579cedf445c0ddc9e7d6c14716460bcd653
                    quantityTo);
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}