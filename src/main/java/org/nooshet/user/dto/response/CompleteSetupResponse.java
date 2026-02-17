package org.nooshet.user.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompleteSetupResponse {
    private boolean success;
    private String message;
}
