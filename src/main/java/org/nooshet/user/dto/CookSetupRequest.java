package org.nooshet.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CookSetupRequest {
    @NotBlank
    private String finCode;
    // Add other setup fields as needed
}

