package com.gu;

public class Assignment24 {
    public static void main(String[] args) {
        System.out.println(isSidesOfTriangle(3,3,3));
    }

    public static boolean isSidesOfTriangle(double side1, double side2, double side3){
        return side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1;
    }
}
