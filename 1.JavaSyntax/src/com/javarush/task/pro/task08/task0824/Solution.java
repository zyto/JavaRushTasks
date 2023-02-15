package com.javarush.task.pro.task08.task0824;

/* 
Парадокс Диего
*/

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Diego[] diegos = new Diego[99];
        for (int i = 0; i < diegos.length; i++) {
            diegos[i] = new Diego();
        }

        System.out.print(diegos[0].hashSum + " ^ ");
        Nimrod[] nimrods = dealWithDuplicates(diegos);
        System.out.println(nimrods[0].password + " = " + diegos[0].hashSum);
    }

    public static Nimrod[] dealWithDuplicates(Diego[] diegos) {
        Nimrod[] nimrods = new Nimrod[diegos.length];

        for (int i = 0; i < diegos.length; i++) {
            Nimrod tNimrod = new Nimrod();

            int pass = (int)(Math.random()*Integer.MAX_VALUE);

            tNimrod.password = pass;

            nimrods[i] = tNimrod;
            diegos[i].hashSum ^= pass;
        }

        return nimrods;
    }
}
