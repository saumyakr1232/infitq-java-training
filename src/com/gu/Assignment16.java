package com.gu;

public class Assignment16 {
    private static void exactChange(int onesAvailable,
                                    int fivesAvailable, int amountToBeMade){
        int fivesNeeded, onesNeeded;
        if (amountToBeMade < fivesAvailable * 5 + onesAvailable){
            if(amountToBeMade/5 > fivesAvailable){
                fivesNeeded = fivesAvailable;
                onesNeeded = amountToBeMade - fivesNeeded*5;

            }else{
                fivesNeeded = amountToBeMade/5;
                onesNeeded = amountToBeMade%5;
            }

            System.out.println("Fives Needed :"+ fivesNeeded);
            System.out.println("Ones Needed :" + onesNeeded);
            System.out.println("-----------------------------------");
        }else{
            System.out.println(-1);
            System.out.println("------------------------------------");
        }

    }

    public static void main(String[] args) {
        exactChange(2, 4, 21);
        exactChange(11, 2, 11);
        exactChange(3, 3, 19);

    }
}
