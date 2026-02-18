package org.nooshet.user.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "courier_profiles")
public class CourierProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "bank_account")
    private String bankAccount;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "vehicle_picture")
    private String vehiclePicture;

    @Column(name = "terms_accepted")
    private Boolean termsAccepted;

    public CourierProfile() {
    }

    public CourierProfile(String firstName, String lastName, String phoneNumber, String bankAccount, String vehicleType, String vehiclePicture, Boolean termsAccepted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.bankAccount = bankAccount;
        this.vehicleType = vehicleType;
        this.vehiclePicture = vehiclePicture;
        this.termsAccepted = termsAccepted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehiclePicture() {
        return vehiclePicture;
    }

    public void setVehiclePicture(String vehiclePicture) {
        this.vehiclePicture = vehiclePicture;
    }

    public Boolean getTermsAccepted() {
        return termsAccepted;
    }

    public void setTermsAccepted(Boolean termsAccepted) {
        this.termsAccepted = termsAccepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourierProfile that = (CourierProfile) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(bankAccount, that.bankAccount) && Objects.equals(vehicleType, that.vehicleType) && Objects.equals(vehiclePicture, that.vehiclePicture) && Objects.equals(termsAccepted, that.termsAccepted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, bankAccount, vehicleType, vehiclePicture, termsAccepted);
    }

    @Override
    public String toString() {
        return "CourierProfile{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehiclePicture='" + vehiclePicture + '\'' +
                ", termsAccepted=" + termsAccepted +
                '}';
    }
}
