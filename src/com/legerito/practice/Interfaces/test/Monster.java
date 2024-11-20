package com.legerito.practice.Interfaces.test;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{

    private String name;
    private int strength;
    private int hitPoints;

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public Monster(String name, int strength, int hitPoints) {
        this.name = name;
        this.strength = strength;
        this.hitPoints = hitPoints;
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0, name);
        values.add(1, "" + hitPoints);
        values.add(2, "" + strength);
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if(savedValues != null && !savedValues.isEmpty()) {
            name = savedValues.get(0);
            hitPoints = Integer.parseInt(savedValues.get(1));
            strength = Integer.parseInt(savedValues.get(2));
        }
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", hitPoints=" + hitPoints +
                '}';
    }
}
