package org.example;

import java.io.IOException;

public class GeographicalLocationEndpoint {
    private GoogleMapsClient googleMapsClient;

    public GeographicalLocationEndpoint(GoogleMapsClient googleMapsClient) {
        this.googleMapsClient = googleMapsClient;
    }

    public String handleRequest(String address) throws IOException {
        return googleMapsClient.getGeographicLocation(address);
    }
}