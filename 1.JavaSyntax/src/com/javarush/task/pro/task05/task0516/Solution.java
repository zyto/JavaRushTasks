package com.javarush.task.pro.task05.task0516;

import java.util.Arrays;

/* 
Заполняем массив
*/

public class Solution {

    public static int[] array = new int[19];
    public static int valueStart = 10;
    public static int valueEnd = 13;

    public static void main(String[] args) {
        //напишите тут ваш код
        int half = (int)Math.ceil(array.length/2.0);

        Arrays.fill(array, 0, half, valueStart);
        Arrays.fill(array, half, array.length, valueEnd);

        System.out.println(Arrays.toString(array));
    }
}
