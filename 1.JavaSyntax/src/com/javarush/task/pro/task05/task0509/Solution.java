package com.javarush.task.pro.task05.task0509;

/* 
Таблица умножения
*/

public class Solution {

    public static int[][] MULTIPLICATION_TABLE = new int[10][10];

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                MULTIPLICATION_TABLE[i][j] = (i+1) * (j+1);
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(MULTIPLICATION_TABLE[i][j] + " ");
            }

            System.out.println(MULTIPLICATION_TABLE[i][9]);

        }
    }
}
