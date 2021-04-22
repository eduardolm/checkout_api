package one.digitalinnovation.ecommerce.checkout.service;

import one.digitalinnovation.ecommerce.checkout.controller.request.CheckoutRequestDto;
import one.digitalinnovation.ecommerce.checkout.controller.response.CheckoutResponseDto;
import one.digitalinnovation.ecommerce.checkout.event.CheckoutCreatedEvent;
import one.digitalinnovation.ecommerce.checkout.model.Checkout;
import one.digitalinnovation.ecommerce.checkout.model.CheckoutItem;
import one.digitalinnovation.ecommerce.checkout.model.Shipping;
import one.digitalinnovation.ecommerce.checkout.repository.CheckoutRepository;
import one.digitalinnovation.ecommerce.checkout.streaming.CheckoutCreatedSource;
import org.hibernate.annotations.Check;
import org.springframework.kafka.listener.BatchAcknowledgingConsumerAwareMessageListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private final CheckoutRepository checkoutRepository;
    private final CheckoutCreatedSource checkoutCreatedSource;

    public CheckoutServiceImpl(CheckoutRepository checkoutRepository, CheckoutCreatedSource checkoutCreatedSource) {
        this.checkoutRepository = checkoutRepository;
        this.checkoutCreatedSource = checkoutCreatedSource;
    }

    @Override
    public Optional<CheckoutResponseDto> create(CheckoutRequestDto checkoutRequestDto) {
        Checkout checkout = new Checkout(
                UUID.randomUUID().toString(),
                Checkout.Status.CREATED,
                checkoutRequestDto.isSaveAddress(),
                checkoutRequestDto.isSaveInfo(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                new Shipping(
                        checkoutRequestDto.getAddress(),
                        checkoutRequestDto.getComplement(),
                        checkoutRequestDto.getCountry(),
                        checkoutRequestDto.getState(),
                        checkoutRequestDto.getZip()));

        checkout.setItems(checkoutRequestDto.getProducts().stream()
                .map(product -> new CheckoutItem(product, checkout)).collect(Collectors.toList()));
        final Checkout newCheckout = checkoutRepository.save(checkout);

        final CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
                .setCheckoutCode(checkout.getCode())
                .setStatus(checkout.getStatus().name())
                .build();

        checkoutCreatedSource.output().send(MessageBuilder.withPayload(checkoutCreatedEvent).build());
        return Optional.of(new CheckoutResponseDto(newCheckout));
    }

    @Override
    public Optional<Checkout> update(String checkoutCode, Checkout.Status status) {
        final Checkout checkout = checkoutRepository.findByCode(checkoutCode).orElse(new Checkout());
        checkout.setStatus(Checkout.Status.APPROVED);
        return Optional.of(checkoutRepository.save(checkout));
    }
}
