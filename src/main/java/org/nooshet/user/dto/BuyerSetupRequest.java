package org.nooshet.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyerSetupRequest {
    // Optional human-readable address. If not provided but lat/lon are
    // present, the service will automatically reverse-geocode and fill this.
    private String addressText;

    // Latitude and longitude provided by the client when adding an address.
    // Use Double so they can be null when not supplied.
    private Double lat;
    private Double lon;
}
