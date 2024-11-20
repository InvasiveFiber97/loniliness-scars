package com.legerito.practice.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class MethodRefs {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("Hiten", "Aniket", "Sunny", "Atharva"));

        list.forEach(System.out::println);

        calculator(Integer::max, 10, 25);
        calculator(String::concat, "Hello ", "World!");
        UnaryOperator<String> u1 = String::toUpperCase;
        String result = "hiten".transform(String::toUpperCase);
        System.out.println(result.transform(String::isEmpty));
    }

    public static <T> void calculator(BinaryOperator<T> function, T v1, T v2) {
        T result = function.apply(v1, v2);
        System.out.println("Result : " + result);
    }
}
