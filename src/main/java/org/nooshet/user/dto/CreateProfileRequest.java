package org.nooshet.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProfileRequest {
    private Long userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String role;
}

