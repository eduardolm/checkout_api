package one.digitalinnovation.ecommerce.checkout.controller.response;

import one.digitalinnovation.ecommerce.checkout.model.Checkout;

public class CheckoutResponseDto {

    private String code;

    @Deprecated
    public CheckoutResponseDto() {
    }

    public CheckoutResponseDto(String code) {
        this.code = code;
    }

    public CheckoutResponseDto(Checkout checkout) {
        this.code = checkout.getCode();
    }

    public String getCode() {
        return code;
    }
}
