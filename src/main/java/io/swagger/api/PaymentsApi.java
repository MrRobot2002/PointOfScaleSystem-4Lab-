/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.51).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import org.threeten.bp.OffsetDateTime;
import io.swagger.model.PaymentDetail;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@Validated
public interface PaymentsApi {

    @Operation(summary = "List all payment records", description = "Retrieves a list of all payments.", security = {
        @SecurityRequirement(name = "BearerAuth")    }, tags={ "Payment" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A list of payments", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PaymentDetail.class)))) })
    @RequestMapping(value = "/payments",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<PaymentDetail>> listPayments(@Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "orderId", required = false) Long orderId
, @Parameter(in = ParameterIn.QUERY, description = "Filter by payment type (CARD, CASH, COUPON)" ,schema=@Schema()) @Valid @RequestParam(value = "paymentType", required = false) String paymentType
, @Parameter(in = ParameterIn.QUERY, description = "Filter by payment state (NULL, PENDING, PARTIALLY_PAID, PAID)" ,schema=@Schema()) @Valid @RequestParam(value = "paymentState", required = false) String paymentState
, @Parameter(in = ParameterIn.QUERY, description = "Filter by payment date range" ,schema=@Schema()) @Valid @RequestParam(value = "dateRangeStart", required = false) OffsetDateTime dateRangeStart
, @Parameter(in = ParameterIn.QUERY, description = "Filter by payment date range" ,schema=@Schema()) @Valid @RequestParam(value = "dateRangeEnd", required = false) OffsetDateTime dateRangeEnd
);

}

