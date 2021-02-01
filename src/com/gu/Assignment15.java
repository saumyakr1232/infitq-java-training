package com.gu;

public class Assignment15 {
    private static double product(int first, int second, int third){
        if (7 != first && 7 != second && 7 != third){
            return first * second * third;
        }else{
            if (7 == first){
                return second * third;
            }
            if (7 == second){
                return third;
            }else {
                return -1;
            }

        }

    }

    public static void main(String[] args) {
        System.out.println(product(1,5,3));
        System.out.println(product(3,7,8));
        System.out.println(product(7,4,3));
        System.out.println(product(1,5,7));
        System.out.println(product(7,7,3));

    }
}
