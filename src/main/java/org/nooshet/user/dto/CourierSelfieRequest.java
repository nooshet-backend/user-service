package org.nooshet.user.dto;

import org.springframework.web.multipart.MultipartFile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourierSelfieRequest {
    private MultipartFile selfie;
}

