package com.example.simple_biosamples_client.models.ga4ghmetadata;

public class GeoLocation {
    private String label;
    private String orecision;
    private double latitude;
    private double longtitude;
    private double altitude;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getOrecision() {
        return orecision;
    }

    public void setOrecision(String orecision) {
        this.orecision = orecision;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }
}
