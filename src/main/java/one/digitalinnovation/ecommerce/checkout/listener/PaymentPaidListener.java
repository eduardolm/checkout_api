package one.digitalinnovation.ecommerce.checkout.listener;

import one.digitalinnovation.ecommerce.checkout.model.Checkout;
import one.digitalinnovation.ecommerce.checkout.repository.CheckoutRepository;
import one.digitalinnovation.ecommerce.checkout.streaming.PaymentPaidSink;
import one.digitalinnovation.ecommerce.payment.event.PaymentCreatedEvent;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentPaidListener {

    private final CheckoutRepository checkoutRepository;

    public PaymentPaidListener(CheckoutRepository checkoutRepository) {
        this.checkoutRepository = checkoutRepository;
    }

    @StreamListener(PaymentPaidSink.INPUT)
    public void handle(PaymentCreatedEvent event) {
        final Checkout checkout = checkoutRepository.findByCode(event.getCheckoutCode().toString()).orElseThrow();
        checkout.setStatus(Checkout.Status.APPROVED);
        checkoutRepository.save(checkout);
    }
}
