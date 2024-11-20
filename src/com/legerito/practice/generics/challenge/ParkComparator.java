package com.legerito.practice.generics.challenge;

import java.util.Comparator;

public class ParkComparator implements Comparator<Park> {

    @Override
    public int compare(Park o1, Park o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
