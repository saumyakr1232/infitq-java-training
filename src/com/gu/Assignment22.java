package com.gu;




public class Assignment22 {
    public static void main(String[] args) {
        for (int year : next15LeapYears(2002)){
            System.out.print(year + ", ");
        }
    }


    public static int[] next15LeapYears(int fromYear){
        int[] next15LeapYears = new int[15];

        for (int i = 0; i<15 ; i++){
            if(isLeapYear(fromYear)){
                next15LeapYears[i] = fromYear;
                fromYear += 1;
            }
            else {
                while(!isLeapYear(fromYear)) {
                    fromYear += 1;
                }
                next15LeapYears[i] = fromYear;
                fromYear += 1;
            }
//            System.out.println("i :" + i);
        }



        return next15LeapYears;
    }

    private static boolean isLeapYear(int year){
        if(year % 400 == 0){
                return true;
        }else if (year % 100 == 0){
            return false;
        }else return year % 4 == 0;
    }
}

