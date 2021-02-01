package com.gu;

import java.util.*;
class Vpl1{



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String output = "";

        int n = Integer.parseInt(sc.next());
        char[][] constelation = new char[3][n];

        for (int i=0; i<3; i++){
            for (int j =0; j < n; j++){
                constelation[i][j] = sc.next().charAt(0);
            }
        }

        System.out.println(Arrays.deepToString(constelation));

        if(constelation[0][0] == '#'){
            output += '#';
        }else{
            int trigger = 0;
            int i;
            for (i =0 ;i<n; i++){
                if (constelation[0][i] == '#'){
                    char[][] temp = new char[3][3];
                    for (int j =0; j<3;j++){
                        for (int k = 0; k<3; k++){
                            temp[j][k] = constelation[j][i-(3-k)];
                            System.out.println(j + " " + k + " : " + constelation[j][i-(3-k)]);
                        }

                    }
                    output += findVowelPattern(temp);
                    output += '#';
                    trigger = i;


                }
            }
            if (trigger!= constelation.length){
                System.out.println("Here" + trigger);

                char[][] temp2 = new char[3][3];
                for (int m = trigger+3; m < constelation.length; m += 3){
                    System.out.println("here" + m);
                    for (int j =0; j<3;j++){
                        for (int k = 0; k<3; k++){
                            temp2[j][k] = constelation[j][m-(3-k)];
                            System.out.println(j + " " + k + " : " + constelation[j][m-(3-k)]);
                        }

                    }
                    output += findVowelPattern(temp2);
                }

            }

        }

        System.out.println(output);



    }

    private static char findVowelPattern(char[][] matrix){
        System.out.println(Arrays.deepToString(matrix));

        /***
         * Assumptions:-
         *  1 matrix is 3x3
         *  2 matrix contains only '*' and '.'
         *  3 Pattern is a vowel
         */
        // A E I O U

        if(matrix[0][0] == '.'){ //A
            return 'A';
        }else if(matrix[0][1] == '.' && matrix[1][1] == '.'){ // U
            return 'U';
        }else if (matrix[1][1] == '.'){ // O
            return 'O';
        }else if (matrix[1][0] == '.' && matrix[1][2] == '.') { // I
            return 'I';
        }else {
            return 'E';
        }
    }
}

class CyclicPalindrome{
    private static boolean isPalindrome(String st){
        String reverse = ""; // Objects of String class

        int length = st.length();
        for ( int i = length - 1; i >= 0; i-- )
            reverse = reverse + st.charAt(i);
        if (st.equals(reverse))
            return true;
        else
           return false;
    }

    public static int cyclicPalindrome(String st){
        if (isPalindrome(st)){
            return 0;
        }
        int n = st.length();
        for (int i =0; i<st.length()-1; i++){
            String head = st.substring(0, 1);
            String body1 = st.substring(1, n);
            String tail = st.substring(n-1, n);
            String body2 = st.substring(0, n-1);

            System.out.println(head + " " + body1);
            System.out.println(tail + " " + body2);
            if (isPalindrome(body1 + head) || isPalindrome(tail + body2) ){
                return i+1;
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        for (int i = 0; i <n; i++) {
            String temp = sc.next();
            System.out.println(cyclicPalindrome(temp));
        }

    }




}


