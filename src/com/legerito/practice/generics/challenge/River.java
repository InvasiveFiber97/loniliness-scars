package com.legerito.practice.generics.challenge;

public class River extends Line{

    private final String name;

    public River(String name, String... locations) {
        super(locations);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "River " + name;
    }
}
