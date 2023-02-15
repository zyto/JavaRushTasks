package com.javarush.task.pro.task09.task0908;

import java.util.Arrays;
import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        if (binaryNumber == "" || binaryNumber == null){
            return "";
        }

        String hexNumber = "";

        while (binaryNumber.length() % 4 != 0){
            binaryNumber = "0"+binaryNumber;
        }

        for (int i = 0; i < binaryNumber.length()/4; i++) {
            String bits = binaryNumber.substring(i*4,i*4+4);

            String ch = "";

            if (bits.equals("0000")){
                ch = "0";
            }else if (bits.equals("0001")){
                ch = "1";
            }else if(bits.equals("0010")){
                ch = "2";
            }else if (bits.equals("0011")){
                ch = "3";
            }else if (bits.equals("0100")){
                ch = "4";
            }else if (bits.equals("0101")){
                ch = "5";
            }else if (bits.equals("0110")){
                ch = "6";
            }else if (bits.equals("0111")){
                ch = "7";
            }else if (bits.equals("1000")){
                ch = "8";
            }else if (bits.equals("1001")){
                ch = "9";
            }else if (bits.equals("1010")){
                ch = "a";
            }else if (bits.equals("1011")){
                ch = "b";
            }else if (bits.equals("1100")){
                ch = "c";
            }else if (bits.equals("1101")){
                ch = "d";
            }else if (bits.equals("1110")){
                ch = "e";
            }else if (bits.equals("1111")){
                ch = "f";
            }else{
                return "";
            }

            hexNumber += ch;
        }

        return hexNumber;
    }

    public static String toBinary(String hexNumber) {
        if (hexNumber == "" || hexNumber == null){
            return "";
        }

        String binaryNumber = "";

        for (int i = 0; i < hexNumber.length(); i++) {
            char ch = hexNumber.charAt(i);

            String bits = "";

            if (ch == '0'){
                bits = "0000";
            }else if (ch == '1'){
                bits = "0001";
            }else if (ch == '2'){
                bits = "0010";
            }else if (ch == '3'){
                bits = "0011";
            }else if (ch == '4'){
                bits = "0100";
            }else if (ch == '5'){
                bits = "0101";
            }else if (ch == '6'){
                bits = "0110";
            }else if (ch == '7'){
                bits = "0111";
            }else if (ch == '8'){
                bits = "1000";
            }else if (ch == '9'){
                bits = "1001";
            }else if (ch == 'a'){
                bits = "1010";
            }else if (ch == 'b'){
                bits = "1011";
            }else if (ch == 'c'){
                bits = "1100";
            }else if (ch == 'd'){
                bits = "1101";
            }else if (ch == 'e'){
                bits = "1110";
            }else if (ch == 'f'){
                bits = "1111";
            }else{
                return "";
            }

            binaryNumber += bits;

        }

        return binaryNumber;
    }
}
