package org.nooshet.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.nooshet.user.dto.CreateProfileRequest;
import org.nooshet.user.dto.request.CreateChefProfileRequest;
import org.nooshet.user.dto.request.CreateCourierProfileRequest;
import org.nooshet.user.dto.request.SetupRequest;
import org.nooshet.user.dto.response.CompleteSetupResponse;
import org.nooshet.user.dto.response.SetupResponse;
import org.nooshet.user.entity.ChefProfile;
import org.nooshet.user.entity.CourierProfile;
import org.nooshet.user.entity.UserProfile;
import org.nooshet.user.repository.ChefProfileRepository;
import org.nooshet.user.repository.CourierProfileRepository;
import org.nooshet.user.repository.UserProfileRepository;
import org.nooshet.user.service.UserProfileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final ChefProfileRepository chefProfileRepository;
    private final CourierProfileRepository courierProfileRepository;

    @Override
    @Transactional
    public void createProfile(CreateProfileRequest request) {
        if (userProfileRepository.existsByAccountId(request.getUserId())) {
            return;
        }

        UserProfile userProfile = new UserProfile();
        userProfile.setAccountId(request.getUserId());
        userProfile.setName(request.getFirstName() + " " + request.getLastName());

        userProfileRepository.save(userProfile);

        String role = request.getRole();

        if (role == null || role.isBlank()) {
            return;
        }

        switch (role.toUpperCase()) {
            case "CHEF" -> createChefProfile(buildChefRequest(request));

            case "COURIER" -> createCourierProfile(buildCourierRequest(request));

            case "BUYER" -> {}

            default -> throw new IllegalArgumentException("Invalid role: " + role);
        }
    }

    private void createChefProfile(CreateChefProfileRequest request) {
        ChefProfile chef = new ChefProfile();
        chef.setAccountId(request.getUserId());
        chef.setFirstName(request.getFirstName());
        chef.setLastName(request.getLastName());
        chef.setEmail(request.getEmail());
        chef.setAddress(request.getAddress());
        chef.setBankAccount(request.getBankAccount());
        chef.setKitchenPicture(request.getKitchenPicture());
        chef.setTermsAccepted(request.getTermsAccepted());
        chefProfileRepository.save(chef);
    }

    private void createCourierProfile(CreateCourierProfileRequest request) {
        CourierProfile courier = new CourierProfile();
        courier.setAccountId(request.getUserId());
        courier.setFirstName(request.getFirstName());
        courier.setLastName(request.getLastName());
        courier.setPhoneNumber(request.getPhone());
        courier.setBankAccount(request.getBankAccount());
        courier.setVehicleType(request.getVehicleType());
        courier.setVehiclePicture(request.getVehiclePicture());
        courier.setTermsAccepted(request.getTermsAccepted());
        courierProfileRepository.save(courier);
    }

    private CreateChefProfileRequest buildChefRequest(CreateProfileRequest request) {
        CreateChefProfileRequest dto = new CreateChefProfileRequest();
        dto.setUserId(request.getUserId());
        dto.setFirstName(request.getFirstName());
        dto.setLastName(request.getLastName());
        dto.setEmail(request.getEmail());
        return dto;
    }

    private CreateCourierProfileRequest buildCourierRequest(CreateProfileRequest request) {
        CreateCourierProfileRequest dto = new CreateCourierProfileRequest();
        dto.setUserId(request.getUserId());
        dto.setFirstName(request.getFirstName());
        dto.setLastName(request.getLastName());
        dto.setPhone(request.getPhone());
        return dto;
    }

    @Override
    public SetupResponse getSetupStatus() {
        // Placeholder
        return SetupResponse.builder().isComplete(false).step("INITIAL").build();
    }

    @Override
    public SetupResponse setupProfile(SetupRequest request) {
        // Placeholder
        return SetupResponse.builder().isComplete(false).step("NEXT").build();
    }

    @Override
    public CompleteSetupResponse completeSetup() {
        return CompleteSetupResponse.builder().success(true).message("Setup completed").build();
    }

    @Override
    public CompleteSetupResponse skipSetup() {
        return CompleteSetupResponse.builder().success(true).message("Setup skipped").build();
    }

    @Override
    @Transactional
    public void deleteProfile(Long accountId) {
        // Delete profiles from all tables if they exist
        UserProfile userProfile = userProfileRepository.findByAccountId(accountId)
                .orElse(null);
        
        if (userProfile != null) {
            // Check for associated chef profile
            chefProfileRepository.deleteByAccountId(accountId);
            // Check for associated courier profile
            courierProfileRepository.deleteByAccountId(accountId);
            
            userProfileRepository.delete(userProfile);
        }
    }
}
