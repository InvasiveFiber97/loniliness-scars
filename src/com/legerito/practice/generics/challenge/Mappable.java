package com.legerito.practice.generics.challenge;

public interface Mappable {

    void render();

    static double[] stringToLatLong(String latLong) {
        String[] coordinates = latLong.split(",");
        double lat = Double.parseDouble(coordinates[0]);
        double lng = Double.parseDouble(coordinates[1]);
        return new double[]{lat,lng};
    }
}
