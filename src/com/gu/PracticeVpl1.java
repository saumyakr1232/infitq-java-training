package com.gu;

// Java implementation of the approach
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

class GFG{

    // Function to return the sorted string
    public static String getSortedString(StringBuilder s,int n)
    {

        // Vectors to store the lowercase
        // and uppercase characters
        Vector<Character> v1 = new Vector<>();
        Vector<Character> v2 = new Vector<>();

        for(int i = 0; i < n; i++)
        {
            if (s.charAt(i) >= 'a' &&
                    s.charAt(i) <= 'z')
                v1.add(s.charAt(i));

            if (s.charAt(i) >= 'A' &&
                    s.charAt(i) <= 'z')
                v2.add(s.charAt(i));
        }

        // Sort both the vectors
        Collections.sort(v1);
        Collections.sort(v2);

        int i = 0, j = 0;

        for(int k = 0; k < n; k++)
        {

            // If current character is lowercase
            // then pick the lowercase character
            // from the sorted list
            if (s.charAt(k)>='a' && s.charAt(k) <= 'z')
            {
                s.setCharAt(k, v1.elementAt(i));
                ++i;
            }

            // Else pick the uppercase character
            else if (s.charAt(k) >='A' &&  s.charAt(k) <= 'Z')
            {
                s.setCharAt(k, v2.elementAt(j));
                ++j;
            }
        }

        // Return the sorted string
        return s.toString();
    }

    // Driver code
    public static void main(String[] args)
    {
        StringBuilder s = new StringBuilder("gEeksfOrgEEkS");
        int n = s.length();

        System.out.println(getSortedString(s, n));
    }
}

class SlowestKey{
    private static char slowestKey(int[][] keyTimes){
        for (int i =0; i < keyTimes.length; i++){
            keyTimes[i][0] += 97;
        }
        char longest_key = 'a';
        int  longest_duration = 0;

        for (int i =0; i< keyTimes.length; i++){
            int start, end, interval;
            int ch;
            if (i == 0){
                 start = 0;
            }else{
                start = keyTimes[i-1][1];
            }
            end = keyTimes[i][1];
            ch = keyTimes[i][0];
            interval = end - start;
            if (longest_duration != 0 || interval > longest_duration){
                longest_duration = interval;
                longest_key = (char) ch;
            }
//            System.out.println(ch);
            return longest_key;
        }
        return longest_key;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int sizeUseless = sc.nextInt();
        int[][] keyTimes = new int[size][2];

        for (int i =0; i < size; i++){
            for (int j = 0; j<2; j++){
                keyTimes[i][j] = sc.nextInt();
            }
        }

        System.out.println(Arrays.deepToString(keyTimes));
        System.out.println(slowestKey(keyTimes));
    }
}

