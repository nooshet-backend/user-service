package org.nooshet.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courier_profiles")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourierProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id", unique = true, nullable = false)
    private Long accountId;

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
}
