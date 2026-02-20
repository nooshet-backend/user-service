package org.nooshet.user.controller;

import lombok.RequiredArgsConstructor;
import org.nooshet.user.service.ReverseGeocodingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// The ReverseGeocodeController was removed per request: reverse geocoding is handled automatically in the service layer
