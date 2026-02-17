package org.nooshet.user.controller;

import lombok.RequiredArgsConstructor;
import org.nooshet.user.dto.CreateProfileRequest;
import org.nooshet.user.entity.UserProfile;
import org.nooshet.user.repository.UserProfileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal/profiles")
@RequiredArgsConstructor
public class InternalProfileController {

    private final UserProfileRepository repository;

    @PostMapping
    public ResponseEntity<Void> createProfile(@RequestBody CreateProfileRequest request) {
        UserProfile p = new UserProfile();
        p.setAccountId(request.getUserId());
        p.setName(request.getFirstName() + " " + request.getLastName());
        repository.save(p);
        return ResponseEntity.ok().build();
    }
}

