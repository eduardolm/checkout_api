package one.digitalinnovation.ecommerce.checkout.controller;

import one.digitalinnovation.ecommerce.checkout.controller.request.CheckoutRequestDto;
import one.digitalinnovation.ecommerce.checkout.service.CheckoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CheckoutRequestDto checkoutRequestDto) {
        return checkoutService.create(checkoutRequestDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.unprocessableEntity().build());
    }
}
