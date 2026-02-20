package org.nooshet.user.service;

public interface ReverseGeocodingService {
    /**
     * Reverse geocode latitude and longitude to a human-readable address text.
     * Returns an empty string if no address is found.
     */
    String reverse(double lat, double lon);
}

