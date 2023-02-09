package com.javarush.task.pro.task05.task0529;

import java.lang.reflect.Array;
import java.util.Arrays;

/* 
Галаксианские роботанки (1)
*/

public class Solution {
    public static String robotank = "☖";
    public static String empty = "_";
    public static String hit = "🎯";
    public static int width = 30, height = 10;
    public static String[][] field = new String[height][width];

    public static int[][] bombs = new int[height][width];

    public static void main(String[] args) {

        for (int i = 0; i < field.length; i++) {
            Arrays.fill(field[i],empty);

            int x = (int) (Math.random() * field[i].length);
            field[i][x] = robotank;

            int tankIndex = 0;

            do {
                Arrays.fill(bombs[i], 0);
                int k = 0;
                while (k < 10) {
                    int y = (int) (Math.random() * field[i].length);

                    if (bombs[i][y] == 0) {
                        bombs[i][y] = 1;
                        k++;

                        if (field[i][y] == robotank)
                            field[i][y] = hit;
                    }
                }

                String[] copy = Arrays.copyOf(field[i],width);
                Arrays.sort(copy);
                tankIndex = Arrays.binarySearch(copy,robotank);

            } while (tankIndex > -1);

            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}
