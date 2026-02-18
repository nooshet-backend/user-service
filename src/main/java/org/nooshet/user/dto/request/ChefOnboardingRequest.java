package org.nooshet.user.dto.request;

import lombok.Data;
import org.nooshet.user.entity.Address;

@Data
public class ChefOnboardingRequest {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String bankAccount;
    private String kitchenPicture;
    private Boolean termsAccepted;
}

