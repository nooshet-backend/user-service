package org.nooshet.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.nooshet.user.dto.CreateProfileRequest;
import org.nooshet.user.entity.UserProfile;
import org.nooshet.user.repository.UserProfileRepository;
import org.nooshet.user.service.UserProfileService;
import org.nooshet.user.dto.request.SetupRequest;
import org.nooshet.user.dto.response.SetupResponse;
import org.nooshet.user.dto.response.CompleteSetupResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

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
    public void createProfile(CreateProfileRequest request) {
        if (userProfileRepository.existsByAccountId(request.getUserId())) {
            return;
        }

        UserProfile profile = new UserProfile();
        profile.setAccountId(request.getUserId());
        profile.setName(request.getFirstName() + " " + request.getLastName());
        profile.setSetupRequired(true);
        // Map other fields if available in UserProfile entity
        
        userProfileRepository.save(profile);

        try {
            if ("CHEF".equalsIgnoreCase(request.getRole())) {
                // Create ChefProfile entity if needed
            } else if ("COURIER".equalsIgnoreCase(request.getRole())) {
                 // Create CourierProfile entity if needed
            }
        } catch (IllegalArgumentException e) {
            // Log warning for unknown role
        }
    }
}
