package com.gu;

public class Assignment4 {
    static double interest(int principal, double rate, int time){
        return (principal * rate * time)/100;
    }

    public static void main(String[] args) {
        System.out.println(interest(20000, 5, 10));
        System.out.println(interest(7800, 7.7, 26));

    }
}
