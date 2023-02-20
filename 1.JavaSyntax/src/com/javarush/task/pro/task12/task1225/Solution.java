package com.javarush.task.pro.task12.task1225;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Аккаунт ИнстаМатрицы
*/

public class Solution {

    public static ArrayList<String> accountsList = new ArrayList<>();

    public static void main(String[] args) {
        convertAccounts();
        registerAccount("Амиго");
        registerAccount("Диего");

        for (int i = 0; i < accountsList.size(); i++) {
            System.out.println(accountsList.get(i));
        }
    }

    public static void convertAccounts() {
        accountsList = new ArrayList<>(Arrays.asList(Accounts.getAccounts()));
    }

    public static void registerAccount(String username) {
        if (!accountsList.contains(username))
            accountsList.add(username);
    }
}