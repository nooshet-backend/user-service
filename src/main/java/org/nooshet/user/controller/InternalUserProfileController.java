package org.nooshet.user.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.nooshet.user.dto.CreateProfileRequest;
import org.nooshet.user.dto.ApiResponse;
import org.nooshet.user.service.UserProfileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/internal/profiles")
@RequiredArgsConstructor
@Hidden
public class InternalUserProfileController {

    private final UserProfileService userProfileService;

    @Value("${internal.token}")
    private String internalToken;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> createProfile(@RequestBody CreateProfileRequest request,
                                                             @RequestHeader("X-Internal-Token") String token) {
        // Simple security check (should be improved)
        if (!internalToken.equals(token)) {
            return ResponseEntity.status(403).body(ApiResponse.error("Unauthorized"));
        }

        userProfileService.createProfile(request);
        return ResponseEntity.ok(ApiResponse.success("Profile created successfully"));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<String>> deleteProfile(@PathVariable Long userId,
                                                             @RequestHeader("X-Internal-Token") String token) {
        if (!internalToken.equals(token)) {
            return ResponseEntity.status(403).body(ApiResponse.error("Unauthorized"));
        }

        userProfileService.deleteProfile(userId);
        return ResponseEntity.ok(ApiResponse.success("Profile deleted successfully"));
    }
}
