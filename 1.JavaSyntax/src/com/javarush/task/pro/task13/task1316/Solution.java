package com.javarush.task.pro.task13.task1316;

public class Solution {

    public static void main(String[] args) {
        var quests = JavarushQuest.values();

        for (var quest : quests){
            System.out.println(quest.ordinal());
        }
    }
}