package com.javarush.task.pro.task09.task0924;

/* 
Взлом Стального Стива
*/

import java.util.Arrays;

public class Solution {

    public static String[][] morals = {{"iAmAKiller", "iAmAThief", "honesty", "responsibility", "iAmABully"},
            {"BuLLyIAmA", "honesty", "iamakiller", "iamathief", "responsibility"},
            {"honesty", "iamabully", "responsibility", "AthiefIAm", "ikillerAmA"},
    };

    public static void main(String[] args) {
        cleanMorals();
        for (String[] strings : morals) {
            System.out.println(Arrays.toString(strings));
        }
    }

    public static void cleanMorals() {

        String[] wrongWords = {"killer", "thief", "bully"};
        String[] rightWords = {"compassion", "fairness", "respect"};

        for (int i = 0; i < morals.length; i++) {
            for (int j = 0; j < morals[i].length; j++) {

                for (int k = 0; k < wrongWords.length; k++) {

                    String wrongWord = wrongWords[k];
                    String rightWord = rightWords[k];

                    if (morals[i][j].toLowerCase().contains(wrongWord)) {

                        morals[i][j] = rightWord;

                    }
                }

            }
        }

    }
}