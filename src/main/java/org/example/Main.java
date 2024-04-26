package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @RestController
    public static class GeographicalLocationController {
        private GoogleMapsClient googleMapsClient;

        public GeographicalLocationController(GoogleMapsClient googleMapsClient) {
            this.googleMapsClient = googleMapsClient;
        }

        @GetMapping("/address/geographic-location")
        public ResponseEntity<?> getGeographicLocation(@RequestParam String address) {
            try {
                String location = googleMapsClient.getGeographicLocation(address);
                return ResponseEntity.ok(location);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao obter a localização geográfica, tente novamente.");
            }
        }
    }
}