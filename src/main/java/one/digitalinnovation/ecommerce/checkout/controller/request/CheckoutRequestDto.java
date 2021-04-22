package one.digitalinnovation.ecommerce.checkout.controller.request;

import java.io.Serializable;
import java.util.List;

public class CheckoutRequestDto implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String complement;
    private String country;
    private String state;
    private String zip;
    private Boolean saveAddress;
    private Boolean saveInfo;
    private String paymentMethod;
    private String cardName;
    private String cardNumber;
    private String cardDate;
    private String cardCvv;
    private List<String> products;

    @Deprecated
    public CheckoutRequestDto() {
    }

    public CheckoutRequestDto(String firstName,
                              String lastName,
                              String email,
                              String address,
                              String complement,
                              String country,
                              String state,
                              String zip,
                              Boolean saveAddress,
                              Boolean saveInfo,
                              String paymentMethod,
                              String cardName,
                              String cardNumber,
                              String cardDate,
                              String cardCvv,
                              List<String> products) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.complement = complement;
        this.country = country;
        this.state = state;
        this.zip = zip;
        this.saveAddress = saveAddress;
        this.saveInfo = saveInfo;
        this.paymentMethod = paymentMethod;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardDate = cardDate;
        this.cardCvv = cardCvv;
        this.products = products;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
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

    public String getZip() {
        return zip;
    }

    public boolean isSaveAddress() {
        return saveAddress;
    }

    public boolean isSaveInfo() {
        return saveInfo;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardDate() {
        return cardDate;
    }

    public String getCardCvv() {
        return cardCvv;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}
