package org.nooshet.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyerSetupRequest {
    @NotBlank
    private String address;
}

