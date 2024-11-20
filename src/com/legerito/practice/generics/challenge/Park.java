package com.legerito.practice.generics.challenge;

public class Park extends Point{

    private final String name;

    public Park(String name, String location) {
        super(location);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " National Park";
    }
}
