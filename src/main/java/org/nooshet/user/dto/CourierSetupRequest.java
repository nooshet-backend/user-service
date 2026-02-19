package org.nooshet.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourierSetupRequest {
    @NotBlank
    private String finCode;
    @NotBlank
    private String transportType; // car, motorcycle, bicycle, foot
    private String licensePlate;
    private String vehicleMake;
    private String vehicleModel;
    private String licenseDocument;
    // Only required for car/motorcycle
}

