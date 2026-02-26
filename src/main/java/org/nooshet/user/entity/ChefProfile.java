package org.nooshet.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
@Table(name = "chef_profiles")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChefProfile {

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
    private String email;

    @Embedded
    private Address address;

    @Column(name = "bank_account")
    private String bankAccount;

    @Column(name = "kitchen_picture")
    private String kitchenPicture;

    @Column(name = "terms_accepted")
    private Boolean termsAccepted;
}
