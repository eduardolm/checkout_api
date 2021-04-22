package one.digitalinnovation.ecommerce.checkout.model;

import javax.persistence.*;

@Entity
public class CheckoutItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product")
    private String product;

    @ManyToOne
    private Checkout checkout;

    @Deprecated
    public CheckoutItem() {
    }

    public CheckoutItem(String product, Checkout checkout) {
        this.product = product;
        this.checkout = checkout;
    }

    public Long getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public Checkout getCheckout() {
        return checkout;
    }
}
