package com.legerito.practice.generics.challenge;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var nationalParks = new Park[] {
                new Park("Jim Corbett", "10,11"),
                new Park("Kaziranga", "20,21")
        };

        Layer<Park> parkLayer = new Layer<>(nationalParks);
        parkLayer.addElements(new Park("Borivali", "30,31"));
        parkLayer.renderLayer();

        var rivers = new River[] {
                new River("Ganga", "10,11", "20,21", "30,31"),
                new River("Bramhaputra", "40,41", "50,51", "60,31")
        };
        Layer<River> riverLayer = new Layer<>(rivers);
        riverLayer.addElements(new River("Narmada", "70,71", "80,81", "90,91"));
        riverLayer.renderLayer();
    }
}
