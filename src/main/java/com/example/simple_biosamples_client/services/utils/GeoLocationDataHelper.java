package com.example.simple_biosamples_client.services.utils;

import java.util.Scanner;

public class GeoLocationDataHelper {

    public boolean isGeoLocationData(String type) {
        boolean isGeolocation = type.contains("geographic location");
        isGeolocation = isGeolocation || type.contains("latitiude");
        isGeolocation = isGeolocation || type.contains("longtitude");
        isGeolocation = isGeolocation || type.contains("altitude");
        return isGeolocation;
    }

    public Location convertToDecimalDegree(String location) {
        int nsCoef = 1;
        if (location.contains("S")) {
            nsCoef = -1;
        }
        int weCoef = 1;
        if (location.contains("W")) {
            weCoef = -1;
        }
        Scanner scanner = new Scanner(location);
        double latitude = scanner.nextDouble();
        double longtitude = scanner.nextDouble();
        return new Location(latitude, longtitude);

    }
}
