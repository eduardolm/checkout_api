package one.digitalinnovation.ecommerce.checkout.repository;

import one.digitalinnovation.ecommerce.checkout.model.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long> {

    Optional<Checkout> findByCode(String code);
}
