package com.models;

public class VehicleData {

    private double altitude;
    private double latitude;
    private double longitude;
    private int satellite_used;
    private double speed;
    private long timestamp;
    private int vehicle_id;
    private String device_id;
    private int signal_quality;
    private int closest_stop_code;
    private double closest_stop_distance_meters;

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getSatellite_used() {
        return satellite_used;
    }

    public void setSatellite_used(int satellite_used) {
        this.satellite_used = satellite_used;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public int getSignal_quality() {
        return signal_quality;
    }

    public void setSignal_quality(int signal_quality) {
        this.signal_quality = signal_quality;
    }

    public int getClosest_stop_code() {
        return closest_stop_code;
    }

    public void setClosest_stop_code(int closest_stop_code) {
        this.closest_stop_code = closest_stop_code;
    }

    public double getClosest_stop_distance_meters() {
        return closest_stop_distance_meters;
    }

    public void setClosest_stop_distance_meters(double closest_stop_distance_meters) {
        this.closest_stop_distance_meters = closest_stop_distance_meters;
    }

    public String toString() {
        return String.format("\t\"altitude\": %f,\n" +
                        "\t\"latitude\": %,.8f,\n" +
                        "\t\"longitude\": %,.8f,\n" +
                        "\t\"satellite_used\": %d,\n" +
                        "\t\"speed\": %,.4f,\n" +
                        "\t\"timestamp\": %d,\n" +
                        "\t\"vehicle_id\": \"%d\",\n" +
                        "\t\"device_id\": \"%s\",\n" +
                        "\t\"signal_quality\": %d,\n" +
                        "\t\"closest_stop_code\": \"%d\",\n" +
                        "\t\"closest_stop_distance_meters\": %,.0f\n", altitude, latitude,
                longitude, satellite_used, speed, timestamp, vehicle_id, device_id,
                signal_quality, closest_stop_code, closest_stop_distance_meters);
    }
}
