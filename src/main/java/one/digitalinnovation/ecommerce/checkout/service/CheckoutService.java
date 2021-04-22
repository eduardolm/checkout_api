package one.digitalinnovation.ecommerce.checkout.service;

import one.digitalinnovation.ecommerce.checkout.controller.request.CheckoutRequestDto;
import one.digitalinnovation.ecommerce.checkout.controller.response.CheckoutResponseDto;
import one.digitalinnovation.ecommerce.checkout.model.Checkout;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutResponseDto> create(CheckoutRequestDto checkoutRequestDto);
    Optional<Checkout> update(String checkoutCode, Checkout.Status status);
}
