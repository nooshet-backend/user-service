package org.nooshet.user.controller;

import org.nooshet.user.service.UserProfileService;
import org.nooshet.user.dto.ApiResponse;
import org.nooshet.user.dto.request.SetupRequest;
import org.nooshet.user.dto.response.SetupResponse;
import org.nooshet.user.dto.response.CompleteSetupResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/me")
@RequiredArgsConstructor
@Tag(name = "User Profile", description = "Endpoints for managing user profile, settings, and account")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @Operation(summary = "Get setup status")
    @GetMapping("/setup")
    public ResponseEntity<ApiResponse<SetupResponse>> getSetup() {
        return ResponseEntity.ok(ApiResponse.success(userProfileService.getSetupStatus()));
    }

    @Operation(summary = "Initial profile setup")
    @PostMapping("/setup")
    public ResponseEntity<ApiResponse<SetupResponse>> setupProfile(@RequestBody SetupRequest request) {
        return ResponseEntity.ok(ApiResponse.success(userProfileService.setupProfile(request)));
    }

    @Operation(summary = "Complete profile setup")
    @PostMapping("/setup/complete")
    public ResponseEntity<ApiResponse<CompleteSetupResponse>> completeSetup() {
        return ResponseEntity.ok(ApiResponse.success(userProfileService.completeSetup()));
    }

    @Operation(summary = "Skip profile setup")
    @PostMapping("/setup/skip")
    public ResponseEntity<ApiResponse<CompleteSetupResponse>> skipSetup() {
        return ResponseEntity.ok(ApiResponse.success(userProfileService.skipSetup()));
    }
}

