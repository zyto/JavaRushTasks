package com.javarush.task.pro.task13.task1318;

/* 
Следующий месяц, пожалуйста
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getNextMonth(Month.JANUARY));
        System.out.println(getNextMonth(Month.JULY));
    }

    public static Month getNextMonth(Month month) {
        Month[] monthes = Month.values();
        int val = month.ordinal();

        if (val >= monthes.length-1){
            val = 0;
        }else {
            val++;
        }

        return monthes[val];
    }
}
