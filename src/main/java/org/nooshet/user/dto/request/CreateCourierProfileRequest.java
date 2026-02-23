package org.nooshet.user.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: nijataghayev
 */

@Getter
@Setter
@Data
public class CreateCourierProfileRequest {
    private Long userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String bankAccount;
    private String vehicleType;
    private String vehiclePicture;
    private Boolean termsAccepted;
}
