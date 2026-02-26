package org.nooshet.user.service;

import org.nooshet.user.dto.CreateProfileRequest;
import org.nooshet.user.dto.request.SetupRequest;
import org.nooshet.user.dto.response.SetupResponse;
import org.nooshet.user.dto.response.CompleteSetupResponse;

public interface UserProfileService {
    SetupResponse getSetupStatus();
    SetupResponse setupProfile(SetupRequest request);
    CompleteSetupResponse completeSetup();
    CompleteSetupResponse skipSetup();
    void createProfile(CreateProfileRequest request);
    void deleteProfile(Long accountId);
}
