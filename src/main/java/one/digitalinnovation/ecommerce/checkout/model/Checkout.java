package one.digitalinnovation.ecommerce.checkout.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column
    private Boolean saveAddress;

    @Column
    private Boolean saveInformation;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    private Shipping shipping;

    @OneToMany(mappedBy = "checkout", cascade = CascadeType.ALL)
    private List<CheckoutItem> items;

    public enum Status {
        CREATED,
        APPROVED
    }

    @Deprecated
    public Checkout() {
    }

    public Checkout(String code, Status status, Boolean saveAddress, Boolean saveInformation, LocalDateTime createdAt,
                    LocalDateTime updatedAt, Shipping shipping) {
        this.code = code;
        this.status = status;
        this.saveAddress = saveAddress;
        this.saveInformation = saveInformation;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.shipping = shipping;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Status getStatus() {
        return status;
    }

    public Boolean getSaveAddress() {
        return saveAddress;
    }

    public Boolean getSaveInformation() {
        return saveInformation;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public List<CheckoutItem> getItems() {
        return items;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setItems(List<CheckoutItem> items) {
        this.items = items;
    }
}
