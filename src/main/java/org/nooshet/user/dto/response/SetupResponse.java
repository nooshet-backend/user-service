package org.nooshet.user.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SetupResponse {
    private boolean isComplete;
    private String step;
}
