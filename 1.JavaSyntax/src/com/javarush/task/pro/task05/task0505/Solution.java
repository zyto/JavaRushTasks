package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N > 0) {
            int[] array = new int[N];

            int n = 0;

            for (int i = 0; i < N; i++) {
                n = sc.nextInt();

                array[i] = n;
            }

            sc.close();

            if(N%2 == 0){
                for (int i = N-1; i >= 0; i--) {
                    System.out.println(array[i]);
                }
            }else{
                for (int i = 0; i < N; i++) {
                    System.out.println(array[i]);
                }
            }
        }
    }
}
