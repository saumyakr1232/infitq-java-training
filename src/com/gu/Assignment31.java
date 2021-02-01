package com.gu;

import java.util.Locale;

public class Assignment31 {
    public static boolean checkPalindrome(String string){
        string = string.toLowerCase();
        StringBuilder reverse = new StringBuilder();
        for (int i = string.length()-1; i >= 0; i--){
            reverse.append(string.charAt(i));

        }

        return reverse.toString().equals(string);
    }

    public static void main(String[] args) {
        System.out.println(checkPalindrome("Lol"));
    }
}
