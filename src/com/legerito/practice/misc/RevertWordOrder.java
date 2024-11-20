package com.legerito.practice.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RevertWordOrder {

    public static void main(String[] args) {
        String sentence = "My name is Hiten Maheswari.";
        int sentenceLength = sentence.length();
        List<String> sentenceList = new ArrayList<>();

        int counter = 0;
        int subStringStart = 0;
        while (counter < sentenceLength) {
            if(Character.isWhitespace(sentence.charAt(counter))) {
                sentenceList.add(sentence.substring(subStringStart, counter));
                subStringStart = counter + 1;
            }
            if(counter == sentenceLength -1) {
                sentenceList.add(sentence.substring(subStringStart));
                break;
            }
            counter++;
        }

        String[] wordArray = new String[sentenceList.size()];
        counter = 0;
        for(int i = sentenceList.size() - 1; i >= 0; i--) {
            wordArray[counter] = sentenceList.get(i);
            counter++;
        }
        System.out.println(Arrays.toString(wordArray));
        System.out.println(Arrays.toString(reverseWords("reversed. be should This")));
    }

    private static String[] reverseWords(String sentence) {
        List<String> wordList = new ArrayList<>();
        int start = 0;

        for (int i = 0; i <= sentence.length(); i++) {
            if (i == sentence.length() || Character.isWhitespace(sentence.charAt(i))) {
                if (start < i) {
                    wordList.add(sentence.substring(start, i));
                }
                start = i + 1;
            }
        }

        Collections.reverse(wordList);
        return wordList.toArray(new String[0]);
    }
}
