package org.nooshet.user.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.nooshet.user.dto.CreateProfileRequest;
import org.nooshet.user.dto.ApiResponse;
import org.nooshet.user.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/internal/profiles")
@RequiredArgsConstructor
@Hidden
public class InternalUserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> createProfile(@RequestBody CreateProfileRequest request, @RequestHeader("X-Internal-Secret") String secret) {
        // Simple security check (should be improved)
        if (!"internal-secret".equals(secret)) {
            return ResponseEntity.status(403).body(ApiResponse.error("Unauthorized"));
        }

        userProfileService.createProfile(request);
        return ResponseEntity.ok(ApiResponse.success("Profile created successfully"));
    }
}
