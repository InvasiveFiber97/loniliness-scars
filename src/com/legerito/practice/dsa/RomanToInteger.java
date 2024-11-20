package com.legerito.practice.dsa;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToIntV2("MMCM"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();

        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                ans -= m.get(s.charAt(i));
            } else {
                ans += m.get(s.charAt(i));
            }
        }

        return ans;
    }

    public static int romanToIntV2(String s) {
        int value=0,prev=0;
        for(char ch: s.toCharArray())
        {
            prev = switch (ch) {
                case 'I' -> {
                    value += 1;
                    yield 1;
                }
                case 'V' -> {
                    value += (prev == 1) ? 3 : 5;
                    yield 5;
                }
                case 'X' -> {
                    value += (prev == 1) ? 8 : 10;
                    yield 10;
                }
                case 'L' -> {
                    value += (prev == 10) ? 30 : 50;
                    yield 50;
                }
                case 'C' -> {
                    value += (prev == 10) ? 80 : 100;
                    yield 100;
                }
                case 'D' -> {
                    value += (prev == 100) ? 300 : 500;
                    yield 500;
                }
                case 'M' -> {
                    value += (prev == 100) ? 800 : 1000;
                    yield 1000;
                }
                default -> prev;
            };
        }
        return value;
    }
}
