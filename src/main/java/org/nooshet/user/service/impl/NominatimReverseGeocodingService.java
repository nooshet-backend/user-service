package org.nooshet.user.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.nooshet.user.service.ReverseGeocodingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class NominatimReverseGeocodingService implements ReverseGeocodingService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${reverse.geocode.enabled:true}")
    private boolean enabled;

    @Override
    public String reverse(double lat, double lon) {
        if (!enabled) return "";
        try {
            String q = "format=json&lat=" + URLEncoder.encode(String.valueOf(lat), StandardCharsets.UTF_8) + "&lon=" + URLEncoder.encode(String.valueOf(lon), StandardCharsets.UTF_8) + "&addressdetails=1";
            String urlStr = "https://nominatim.openstreetmap.org/reverse?" + q;
            URL urlObj = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Nooshet-UserService/1.0 (contact@example.com)");
            conn.setRequestProperty("Accept", MediaType.APPLICATION_JSON_VALUE);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            int status = conn.getResponseCode();
            InputStream is = (status >= 200 && status < 300) ? conn.getInputStream() : conn.getErrorStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append('\n');
            }
            br.close();
            String body = sb.toString();
            if (body == null || body.isBlank()) return "";
            JsonNode root = objectMapper.readTree(body);
            if (root.has("display_name")) {
                return root.get("display_name").asText();
            }
            return "";
        } catch (Exception e) {
            // swallow errors and return empty address so service remains resilient
            System.err.println("Reverse geocode failed: " + e.getMessage());
            return "";
        }
    }
}
