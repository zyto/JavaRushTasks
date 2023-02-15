package com.javarush.task.pro.task09.task0915;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        String packagePath = "java.util.stream";
        String[] tokens = getTokens(packagePath, "\\.");
        System.out.println(Arrays.toString(tokens));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query,delimiter);

        ArrayList<String> al = new ArrayList();

        while (st.hasMoreTokens()){
            al.add(st.nextToken());
        }

        String[] res = new String[al.size()];

        for (int i = 0; i < al.size(); i++) {
            res[i] = al.get(i);
        }

        return res;
    }
}
