package com.gu;

import java.util.ArrayList;
import java.util.Arrays;

public class Assignment34 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 7, 4, 5, 6, 0, 3));
        System.out.println(list1);
        System.out.println(findPairsOfNumbers(list1, 6));

    }

    private static int findPairsOfNumbers(ArrayList<Integer> list, int addsUpTo){
        int count = 0;
        for (int i =0; i< list.size(); i++){
            for(int j = i; j<list.size()-1; j++){
                if ((list.get(j) + list.get(i)) == addsUpTo){

                    count++;
                }
            }
        }
        return count;

    }
}
