package org.nooshet.user.service.impl;

import org.nooshet.user.dto.*;
import org.nooshet.user.service.UserSetupService;
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
}
