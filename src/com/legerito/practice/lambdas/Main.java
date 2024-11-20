package com.legerito.practice.lambdas;

import java.util.*;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {

//        List<Double[]> coordinates = Arrays.asList(new Double[]{10.123,11.231}, new Double[]{20.123,21.321}, new Double[]{30.123,31.321});
//        coordinates.forEach(coordinate -> System.out.println("Lat : " + coordinate[0] + ", Long : " + coordinate[1]));

        String[] emptyStrings = new String[] {"bob", "HiTen", "hInaTA", "nARuTo"};
        Arrays.setAll(emptyStrings, i -> emptyStrings[i] + " " + String.valueOf(emptyStrings[i].charAt(0)).toUpperCase() + "." + new StringBuilder(emptyStrings[i]).reverse());
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.asList(emptyStrings).replaceAll(s -> s.toUpperCase());
        System.out.println(Arrays.toString(emptyStrings));

        LinkedList<String> list = new LinkedList<>(Arrays.asList(emptyStrings));

        String sentence = "My name is Hiten";
        Consumer<String> printParts = s -> Arrays.asList(s.split(" ")).forEach(word -> System.out.println(word));
        printParts.accept(sentence);

        UnaryOperator<String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if(i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println(everySecondChar(everySecondChar,"1234567890"));

    }

    private static String getReversedName(String name) {
        return new StringBuilder(name).reverse().toString();
    }

    private static String everySecondChar(Function<String, String> operator, String source) {
        return operator.apply(source);
    }
}
