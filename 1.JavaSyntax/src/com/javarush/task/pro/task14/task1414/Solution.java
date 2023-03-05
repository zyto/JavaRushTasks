package com.javarush.task.pro.task14.task1414;

/* 
Готовим коктейли
*/

public class Solution {

    public static final String OUTPUT_FORMAT = "Метод %s вызван из строки %d класса %s в файле %s.\n";

    public static void main(String[] args) {
        makeScrewdriver();
    }

    public static void printStackTrace(StackTraceElement[] stackTrace) {
        for (StackTraceElement trace: stackTrace){
            System.out.printf("Метод %s вызван из строки %d класса %s в файле %s."
                    , trace.getMethodName(), trace.getLineNumber(), trace.getClassName(), trace.getFileName());
            System.out.println();

        }
    }

    static void makeScrewdriver() {
        addJuice();
    }

    static void addJuice() {
        addVodka();
    }

    static void addVodka() {
        printStackTrace(Thread.currentThread().getStackTrace());
    }
}
