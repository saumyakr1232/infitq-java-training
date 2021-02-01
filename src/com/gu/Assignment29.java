package com.gu;

public class Assignment29 {
    private static final int PRICE_PER_LITER_OF_FUEL = 70;
    private static final int MILEAGE_OF_BUS_KM_PER_LITER = 10;
    private static final int PRICE_PER_TICKET = 80;

    public static void main(String[] args) {
        System.out.println(profit(20, 50));
    }

    public static int profit(int distance, int noOfPassengers){
        int expanse = (distance/ MILEAGE_OF_BUS_KM_PER_LITER) * PRICE_PER_LITER_OF_FUEL;
        int profit = (noOfPassengers * PRICE_PER_TICKET) - expanse ;

        return profit > 0 ?  profit : -1;
    }
}
