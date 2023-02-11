package com.javarush.task.pro.task07.task0706;

/* 
Странное деление
*/

public class Solution {
    public static void main(String[] args) {
        div(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    }

    public static void div(double a, double b){
        System.out.println(b/a);
    }
}
