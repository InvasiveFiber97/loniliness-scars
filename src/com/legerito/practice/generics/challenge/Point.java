package com.legerito.practice.generics.challenge;

import java.util.Arrays;
import java.util.List;

public abstract class Point implements Mappable{

    private final double[] location;

    public Point(String location) {
        this.location = Mappable.stringToLatLong(location);
    }

    @Override
    public void render() {
        System.out.printf("Render: %s as POINT (%s)\n", this, Arrays.toString(location));
    }
}
