package com.javarush.task.pro.task05.task0526;
import java.util.Arrays;
/* 
Атака вирусов
*/

public class Solution {
    public static int[][] array = {
            {1,2,3,4},
            {4,5,6,7},
            {7,8,9,0}
    };

    public static void main(String[] args) {
        printArray();

        for (int i = 0; i < Math.ceil(array.length / 2); i++) {

            //номер противоположной строки
            int k = array.length - i - 1;
            int[] arrayK = array[k];
            array[k] = array[i];
            array[i] = arrayK;

        }

        printArray();
    }

    public static void printArray() {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
