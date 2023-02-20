package com.javarush.task.pro.task12.task1205;

/* 
Метод деления
*/

public class Solution {

    public static void main(String[] args) {
        divide(100, 20);
        divide(1, 0);
        divide(-1, 0);
        divide(0, 0);
        divide(200, 20);
        divide(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public static void divide(double a, double b) {
        if ((a > 0 && b == 0)
                || (a == Double.POSITIVE_INFINITY && b >= 0 && !Double.isInfinite(b))
                || (a == Double.NEGATIVE_INFINITY && b < 0 && !Double.isInfinite(b))) {
            System.out.println(Double.POSITIVE_INFINITY);
        } else if ((a < 0 && b == 0)
                || (a == Double.NEGATIVE_INFINITY && b >= 0 && !Double.isInfinite(b))
                || (a == Double.POSITIVE_INFINITY && b < 0 && !Double.isInfinite(b))) {
            System.out.println(Double.NEGATIVE_INFINITY);
        } else if ((a == 0 && b == 0)
                || (Double.isInfinite(a) || Double.isInfinite(b))
                || (Double.isNaN(a) || Double.isNaN(b))) {
            System.out.println(Double.NaN);
        } else {
            System.out.println(a / b);
        }
    }
}
