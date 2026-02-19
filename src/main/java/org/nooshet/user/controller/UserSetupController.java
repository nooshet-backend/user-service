package org.nooshet.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.nooshet.user.dto.*;
import org.nooshet.user.service.UserSetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "User Setup", description = "Endpoints for user setup and onboarding")
public class UserSetupController {

    private final UserSetupService userSetupService;

    @Autowired
    public UserSetupController(UserSetupService userSetupService) {
        this.userSetupService = userSetupService;
    }

    // --- CLASSIC REGISTRATION (all users) ---
    @Operation(summary = "Classic registration: name, surname, email, phone, password x2")
    @PostMapping("/register")
    public ResponseEntity<Void> classicRegister(@Valid @RequestBody RegisterRequest request) {
        // TODO: Generate userId, call userSetupService.createUserProfileOnRegistration
        return ResponseEntity.ok().build();
    }

    // --- SETUP FLOW (per user type) ---
    // HOME COOK SETUP
    @Operation(summary = "Home Cook setup: FIN code, kitchen photos, etc.")
    @PutMapping("/setup/cook")
    public ResponseEntity<Void> setupCook(@Valid @RequestBody CookSetupRequest request) {
        userSetupService.setupCook(request);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Complete Home Cook setup")
    @PutMapping("/setup/cook/complete")
    public ResponseEntity<Void> completeCookSetup() {
        userSetupService.completeCookSetup();
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Upload Home Cook kitchen photos")
    @PutMapping("/setup/cook/kitchen-photos")
    public ResponseEntity<Void> uploadCookKitchenPhotos(@ModelAttribute CookKitchenPhotoRequest request) {
        userSetupService.uploadCookKitchenPhoto(request);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Delete Home Cook kitchen photo")
    @DeleteMapping("/setup/cook/kitchen-photos")
    public ResponseEntity<Void> deleteCookKitchenPhoto(@RequestParam String photoId) {
        userSetupService.deleteCookKitchenPhoto(photoId);
        return ResponseEntity.ok().build();
    }

    // COURIER SETUP
    @Operation(summary = "Courier setup: FIN code, transport, selfie, etc.")
    @PutMapping("/setup/courier")
    public ResponseEntity<Void> setupCourier(@Valid @RequestBody CourierSetupRequest request) {
        userSetupService.setupCourier(request);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Complete Courier setup")
    @PutMapping("/setup/courier/complete")
    public ResponseEntity<Void> completeCourierSetup() {
        userSetupService.completeCourierSetup();
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Upload Courier self-photo (one-time only)")
    @PutMapping("/setup/courier/selfie")
    public ResponseEntity<Void> uploadCourierSelfie(@ModelAttribute CourierSelfieRequest request) {
        userSetupService.uploadCourierSelfie(request);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Delete Courier self-photo")
    @DeleteMapping("/setup/courier/selfie")
    public ResponseEntity<Void> deleteCourierSelfie() {
        userSetupService.deleteCourierSelfie();
        return ResponseEntity.ok().build();
    }

    // BUYER SETUP
    @Operation(summary = "Buyer setup: address, etc.")
    @PutMapping("/setup/buyer")
    public ResponseEntity<Void> setupBuyer(@Valid @RequestBody BuyerSetupRequest request) {
        userSetupService.setupBuyer(request);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Complete Buyer setup")
    @PutMapping("/setup/buyer/complete")
    public ResponseEntity<Void> completeBuyerSetup() {
        userSetupService.completeBuyerSetup();
        return ResponseEntity.ok().build();
    }
}
