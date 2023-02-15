package com.javarush.task.pro.task09.task0923;

/* 
Ранг доступа — Пиратский Капитан
*/

import static com.javarush.task.pro.task09.task0923.CaptainBridge.checkAccess;

public class Solution {
    public static void main(String[] args) {
        String[] ranks = {"Раб", "Гость", "Боец", "Ветеран", "Картографист", "Капитан", "Стив"};
        String rightRank = "";

        for (int i = 0; i < ranks.length; i++) {
            if (CaptainBridge.debugAccess(ranks[i])){
                rightRank = ranks[i];
            }
        }

        checkAccess(rightRank);
    }
}
