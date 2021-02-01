package com.gu;

public class Assignment3 {
    public static void main(String[] args) {

        int mileage = 12;
        int fuelRate = 65;
        int distance_one_way = 96;


        System.out.println(divisibleByFive(mileage,fuelRate,
                distance_one_way));


    }

    public static boolean divisibleByFive(int mileage, int fuelRate,
                                          int distance_one_way){
        int perHead_cost = (((distance_one_way*2) / mileage) * fuelRate) / 4;

        System.out.println(perHead_cost);

        if (perHead_cost % 5 == 0) return true;
        else return false;
    }

}
