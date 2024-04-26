package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

class GoogleMapsClient {
    private GoogleMapsConfig config;

    public GoogleMapsClient(GoogleMapsConfig config) {
        this.config = config;
    }

    public String getGeographicLocation(String address) throws IOException {
        String apiKey = config.getApiKey();
        String urlStr = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + apiKey;

        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        Scanner scanner = new Scanner(conn.getInputStream());
        StringBuilder response = new StringBuilder();
        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close();

        return response.toString();
    }
}
