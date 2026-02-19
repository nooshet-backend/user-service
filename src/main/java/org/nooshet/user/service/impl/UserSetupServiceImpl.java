package org.nooshet.user.service.impl;

import org.nooshet.user.dto.*;
import org.nooshet.user.service.UserSetupService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserSetupServiceImpl implements UserSetupService {
    @Override
    public void createUserProfileOnRegistration(String userId, String firstName, String lastName, String email, String phone) {
        // Create user profile
    }

    @Override
    public void setupCook(String userId, CookSetupRequest request) {
        // Save FIN code, etc. for cook
    }

    @Override
    public void uploadCookKitchenPhoto(String userId, CookKitchenPhotoRequest request) {
        // Save kitchen photo for cook
    }

    @Override
    public void deleteCookKitchenPhoto(String userId, String photoId) {
        // Delete kitchen photo for cook
    }

    @Override
    public void completeCookSetup(String userId) {
        // Validate all required cook setup fields
    }

    @Override
    public void setupCourier(String userId, CourierSetupRequest request) {
        // Save FIN code, transport, etc. for courier
    }

    @Override
    public void uploadCourierSelfie(String userId, CourierSelfieRequest request) {
        // Save courier selfie, enforce one-time upload
    }

    @Override
    public void deleteCourierSelfie(String userId) {
        // Delete courier selfie
    }

    @Override
    public void completeCourierSetup(String userId) {
        // Validate all required courier setup fields
    }

    @Override
    public void setupBuyer(String userId, BuyerSetupRequest request) {
        // Save address, etc. for buyer
    }

    @Override
    public void completeBuyerSetup(String userId) {
        // Validate all required buyer setup fields
    }

    // Overloaded methods for extracting userId from JWT
    @Override
    public void setupCook(CookSetupRequest request) {
        String userId = getUserIdFromJwt();
        setupCook(userId, request);
    }

    @Override
    public void uploadCookKitchenPhoto(CookKitchenPhotoRequest request) {
        String userId = getUserIdFromJwt();
        uploadCookKitchenPhoto(userId, request);
    }

    @Override
    public void deleteCookKitchenPhoto(String photoId) {
        String userId = getUserIdFromJwt();
        deleteCookKitchenPhoto(userId, photoId);
    }

    @Override
    public void completeCookSetup() {
        String userId = getUserIdFromJwt();
        completeCookSetup(userId);
    }

    @Override
    public void setupCourier(CourierSetupRequest request) {
        String userId = getUserIdFromJwt();
        setupCourier(userId, request);
    }

    @Override
    public void uploadCourierSelfie(CourierSelfieRequest request) {
        String userId = getUserIdFromJwt();
        uploadCourierSelfie(userId, request);
    }

    @Override
    public void deleteCourierSelfie() {
        String userId = getUserIdFromJwt();
        deleteCourierSelfie(userId);
    }

    @Override
    public void completeCourierSetup() {
        String userId = getUserIdFromJwt();
        completeCourierSetup(userId);
    }

    @Override
    public void setupBuyer(BuyerSetupRequest request) {
        String userId = getUserIdFromJwt();
        setupBuyer(userId, request);
    }

    @Override
    public void completeBuyerSetup() {
        String userId = getUserIdFromJwt();
        completeBuyerSetup(userId);
    }

    private String getUserIdFromJwt() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName(); // Or extract from claims if needed
    }
}
