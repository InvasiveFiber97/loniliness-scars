package com.legerito.practice.generics.challenge;

import java.util.Arrays;

public abstract class Line implements Mappable{

    private double[][] location;

    public Line(String... locations) {
        this.location = new double[locations.length][];
        int index = 0;
        for(String loc : locations) {
            this.location[index++] = Mappable.stringToLatLong(loc);
        }
    }

    @Override
    public void render() {
        System.out.printf("Render: %s as LINE (%s)\n", this, Arrays.deepToString(location));
    }
}
