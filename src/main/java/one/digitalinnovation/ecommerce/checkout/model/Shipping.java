package one.digitalinnovation.ecommerce.checkout.model;

import javax.persistence.*;

@Entity
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "complement")
    private String complement;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String cep;

    @OneToOne(mappedBy = "shipping")
    private Checkout checkout;

    @Deprecated
    public Shipping() {
    }

    public Shipping(String address, String complement, String country, String state, String cep) {
        this.address = address;
        this.complement = complement;
        this.country = country;
        this.state = state;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCep() {
        return cep;
    }

    public Checkout getCheckout() {
        return checkout;
    }
}
