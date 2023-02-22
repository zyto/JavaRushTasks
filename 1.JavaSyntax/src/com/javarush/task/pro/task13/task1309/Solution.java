package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Иванов Иван", 5d);
        grades.put("Сидоров Сидор", 4.5d);
        grades.put("Петров Петр", 4.0);
        grades.put("Федоров Федор",3.0);
        grades.put("Иванов Петр",2.0);
    }
}
