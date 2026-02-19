package org.nooshet.user.service;

import org.nooshet.user.dto.*;

public interface UserSetupService {
    // Called after registration to create user profile
    void createUserProfileOnRegistration(String userId, String firstName, String lastName, String email, String phone);

    // Setup for Home Cook
    void setupCook(String userId, CookSetupRequest request);
    void uploadCookKitchenPhoto(String userId, CookKitchenPhotoRequest request);
    void deleteCookKitchenPhoto(String userId, String photoId);
    void completeCookSetup(String userId);

    // Overloaded methods for extracting userId from JWT
    void setupCook(CookSetupRequest request);
    void uploadCookKitchenPhoto(CookKitchenPhotoRequest request);
    void deleteCookKitchenPhoto(String photoId);
    void completeCookSetup();

    // Setup for Courier
    void setupCourier(String userId, CourierSetupRequest request);
    void uploadCourierSelfie(String userId, CourierSelfieRequest request);
    void deleteCourierSelfie(String userId);
    void completeCourierSetup(String userId);

    // Overloaded methods for extracting userId from JWT
    void setupCourier(CourierSetupRequest request);
    void uploadCourierSelfie(CourierSelfieRequest request);
    void deleteCourierSelfie();
    void completeCourierSetup();

    // Setup for Buyer
    void setupBuyer(String userId, BuyerSetupRequest request);
    void completeBuyerSetup(String userId);

    // Overloaded methods for extracting userId from JWT
    void setupBuyer(BuyerSetupRequest request);
    void completeBuyerSetup();
}
