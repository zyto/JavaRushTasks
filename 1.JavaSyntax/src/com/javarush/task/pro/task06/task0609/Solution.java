package com.javarush.task.pro.task06.task0609;

/* 
Кубический калькулятор в кубе
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static long cube(long num){
        return num*num*num;
    }

    public static long ninthDegree(long num){
        return cube(cube(num));
    }
}
