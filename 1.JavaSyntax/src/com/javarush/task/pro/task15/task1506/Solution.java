package com.javarush.task.pro.task15.task1506;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();

        try{
            var list = Files.readAllLines(Path.of(fileName));
            for (String l : list){
                for(char c: l.toCharArray()){
                    if (c == '.' || c == ',' || c == ' '){
                        continue;
                    }
                    System.out.print(c);
                }
                System.out.println();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

