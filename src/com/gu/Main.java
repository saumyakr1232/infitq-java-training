package com.gu;
import java.util.*;


public class Main {

    public static void main(String[] args) {
//        HashMap<String, Integer> menu = new HashMap<>();
//        menu.put("Veg Roll", 2);
//        menu.put("Noodles" , 200);
//        menu.put("Fired Rice", 250);
//        menu.put("Soup", 3);
//        Assignment39 assignment39 = new Assignment39(menu);
//
//        HashMap<String, Integer>  order = new HashMap<>();
//        order.put("Veg Roll", 3);
//        order.put("Noodles", 10);
//        order.put("Soup", 1);
//        System.out.println(assignment39.placeOrder(order));

//        List<Integer> a = new ArrayList<>();
//        a.add(5);
//        a.add(6);
//        a.add(1);


    }

}
class Assignment39{
    final HashMap<String , Integer> menu;
    public Assignment39(HashMap<String, Integer> menu){

        this.menu = menu;
    }
    public String placeOrder(HashMap<String, Integer> order){


        String message = "";

        for (String item: order.keySet()){
            if (checkQuantityAvailable(item, order.get(item))){
                message += item + " is available\n";
            }else{
                message += item + " is not available\n";
            }
        }

        return message;
    }

    private boolean checkQuantityAvailable(String item, int quantityRequested){
        if (menu.get(item) >= quantityRequested){
            menu.put(item, menu.get(item) - quantityRequested);
            return true;
        }
        return false;
    }
}

class Assignment50{
    public static String smsEncoding(String sms){
        String encodedSms = "";
        ArrayList<String> encodedWords = new ArrayList<>();
        ArrayList<String > words = new ArrayList<>(Arrays.asList(sms.split(" ")));
        ArrayList<String> vowels = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u", "A",
                "E" , "I", "O", "U"));
        for (String word : words){
            int consonantCount = 0;
            String newWord = "";
            for (int i = 0; i< word.length(); i++){
                if (!vowels.contains(String.valueOf(word.charAt(i)))){
                    newWord += word.charAt(i);
                    consonantCount++;
                }
            }
            if (consonantCount == 0){
                encodedWords.add(word);
            }else{
                encodedWords.add(newWord);
            }
        }

        for (String s : encodedWords){
            encodedSms += s + " ";
        }

        return  encodedSms;
    }
}

class Assignment49{
    public static int tossCoin(int times){
        int countHead = 0;
        for (int i =0 ; i< times;i ++){
            if (tossCoin().equals("head")){
                countHead ++;
            }
        }
        return countHead;
    }

    private static String tossCoin(){
        ArrayList<String> outcomes = new ArrayList<>();
        for (int i =0; i< 100; i++){
            if (i < 70){
                outcomes.add("head");
            }else{
                outcomes.add("tail");
            }

        }
        Random random = new Random();
        return outcomes.get(random.nextInt(outcomes.size()));
    }
}

class Assignment48{
//    HashMap<String, String> dict = new HashMap<>();
//        dict.put("THEIR", "THEIR");
//        dict.put("BUSINESS", "BISINESS");
//        dict.put("WINDOWS", "WINDMILL");
//        dict.put("WERE", "WEAR");
//        dict.put("SAMPLE", "SAMPLE");
//
//        Assignment48.findCorrect(dict);
    public static void findCorrect(HashMap<String , String > dictionary){

//        ArrayList<Integer> wrongs = new ArrayList<>();

        for (String word: dictionary.keySet()){
            int wrongLetters = 0;
            if (word.equals(dictionary.get(word))){
                wrongLetters = 0;
            }else{
                for (int i =0; i< word.length(); i++){
                    if (word.charAt(i) != dictionary.get(word).charAt(i)){
                        wrongLetters++;
                    }
                }
            }
            System.out.println(word + " : " + dictionary.get(word) + " → " + wrongLetters);
//            wrongs.add(wrongLetters);

        }


    }
}

class Assignment47{
    public  static String encryptSentence(String sentence){
        ArrayList<String> words = new ArrayList<>(Arrays.asList(sentence.split(" ")));
        ArrayList<String> vowels = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));

        ArrayList<String> encryptedWords = new ArrayList<>();

        for(String word: words){
            char[] wordArray = word.toCharArray();

            for (int i =0; i<word.length(); i++){
                if ((i+1) % 2 ==0){ //even position
                    if (i -2 >= 0){ // not the first character
                        if (vowels.contains(String.valueOf(wordArray[i - 2]))){
                            if(!vowels.contains((String.valueOf(wordArray[i])))){
                                char temp = wordArray[i -2];
                                wordArray[i-2] = wordArray[i];
                                wordArray[i] = temp;

                            }
                        }
                    }
                }
                else{ // odd position
                    if (i - 2 >= 0){
                        char temp = wordArray[i -2];
                        wordArray[i-2] = wordArray[i];
                        wordArray[i] = temp;
//                        System.out.println(wordArray);
                    }

                }
            }
            encryptedWords.add(String.valueOf(wordArray));

        }
        String encryptedString = "";
        for (String encryptedWord: encryptedWords){
            encryptedString += encryptedWord + " ";
        }
        return  encryptedString;
    }
}

class Assignment46 {
    public static int nearestPalindrome(int n) {
        while(!isPalindrome(n)){
            n++;
        }
        return n;

    }

    private static boolean isPalindrome(int n){
        int reverse = 0;
        int copyOfN = n;
        while(n!=0){
            int remainder = n % 10;
            reverse  = reverse* 10 + remainder;
            n = n/10;
        }

        return copyOfN == reverse;

    }

}

class Assignment45{
    public static boolean isArmstrong(int n){
        double sum = 0;
        int copyOfN = n;
        int noOfDigits = 0;
        int secondCopyOfN = n;
        while (n != 0){
            n = n/10;
            noOfDigits++;
        }
        while(copyOfN != 0){
            int remainder = copyOfN % 10;
            sum += Math.pow(remainder, noOfDigits);
            copyOfN/= 10;
        }
        System.out.println(sum + " " + secondCopyOfN);
        return secondCopyOfN == sum;
    }
}

class Assignment44{
    public static ArrayList<Integer> findDuplicates(ArrayList<Integer> numbers){
        ArrayList<Integer> duplicates = new ArrayList<>();

        for (Integer no : numbers){
            if (numbers.lastIndexOf(no) != numbers.indexOf(no)){
                if(!duplicates.contains(no)){
                    duplicates.add(no);
                }

            }
        }
        return  duplicates;
    }
}


class Assignment43{
    public static int findSmallestNumber(int n){
        int i = 0;
        int no = 0;
        while(true){
            if (findFactors(i).size() == n){
                no = i;
                break ;
            }else{
                i ++;
            }
        }
        return  no;
    }
    private static ArrayList<Integer> findFactors(int n){
        ArrayList<Integer> factors = new ArrayList<>();

        for (int i =1; i<= n; i++){
            if (n % i ==0){
                factors.add(i);
            }
        }
        return factors;

    }
}

class Assignment42{
    public static int  sumOfLargestPrimeFactors(int n){
        int sum  =0 ;
        for (int i = 0; i<9; i++){
            sum += largestPrimeFactor(n + i);
        }


        return sum;
    }

    private static int largestPrimeFactor(int n){
        int largest = 0;
        for (int i = 2; i<= n/2; i++){
            if(n % i ==0){
                if (isPrime(i) && largest < i ) {
                    largest = i;
                }
            }
        }

        return largest==0 ? n : largest ;
    }

    private static boolean isPrime(int n){

        boolean flag = true;
        for (int i = 2; i<= n/2; i++){
            if (n % i == 0){
                flag = false;
            }
        }
        return  flag;
    }
}

class Assignment41{
    public static ArrayList<String> findTenSubstring(String no){
        ArrayList<String> subs = new ArrayList<>();
        for (int i = 2; i<= no.length() - 2; i++){ //7 2-5
            for (int j=0 ; j<=no.length()-i; j++){
                String sub = no.substring(j, j+i);
//                System.out.print(" " + sub);
                if (sumOfDigits(Integer.parseInt(sub)) == 10){
                    subs.add(sub);
                }
            }
        }

        return subs;
    }

    private static int sumOfDigits(int no){
        int sum = 0;
        while (no !=0){
            sum += no %10;
            no /= 10;
        }
        return sum;
    }
}

class Assignment40{
    public static boolean isPalindrome(String string){
        if (string.length() <= 1){
            return true;
        }else if(string.length() == 2){
            if(string.charAt(0) == string.charAt(string.length()-1)){
                return true;
            }else{
                return false;
            }

        }else{
            string = string.substring(1, string.length()-1);
             return isPalindrome(string);
        }
    }
}

class Assignment38{
    public static boolean checkDouble(int number){
        int doubleOfNo = 2 * number;
        ArrayList<Integer> digitsOfNos = new ArrayList<>();
        ArrayList<Integer> digitsOfDouble = new ArrayList<>();

        while (number !=0){
            digitsOfNos.add(number % 10);
            number /= 10;
        }
        while (doubleOfNo !=0){
            digitsOfDouble.add(doubleOfNo % 10);
            doubleOfNo /= 10;
        }

        return  digitsOfDouble.containsAll(digitsOfNos);


    }

}

class Assignment37{
    static ArrayList<Integer> chocolatesReceived = new ArrayList<>(Arrays.asList(12,5,3,4,6));
    static ArrayList<Integer> childrenList = new ArrayList<>(Arrays.asList(10,20,30,40,50));

    public static int totalChocolates(){
       return chocolatesReceived.stream().mapToInt(Integer:: intValue).sum();
    }
    public static void rewardChild(int id, int chocolates ){
        if (!childrenList.contains(id)){
            System.out.println("Child id is invalid");

        }else if(chocolates < 0){
            System.out.println("Extra chocolates is less than 1");
        }else{
            System.out.println(totalChocolates());
        }


    }

}

class Assignment36{
    public static int createLargestNumber(ArrayList<Integer> nos){
        Collections.sort(nos, Collections.reverseOrder());

        String largestNo = "";
        for (Integer no : nos){
            largestNo += no.toString();
        }

        return Integer.parseInt(largestNo);
    }
}

class  Assignment35{
    public static double findMoreThanAverage(ArrayList<Integer> marks){
        double average = marks.stream().mapToDouble(Integer:: intValue).sum()/marks.size();
        double countAboveAverage = 0;

        for (Integer score : marks){
            if (score >= average){
                countAboveAverage++;
            }
        }

        return (countAboveAverage/marks.size()) * 100;
    }
    public static int[] generateFrequency(ArrayList<Integer> marks){
        int[] freq = new int[25];
        for (int score: marks){
            freq[--score] += 1;
        }
        return freq;
    }
    public static ArrayList<Integer> sortMarks(ArrayList<Integer> marks){
        Collections.sort(marks);
       return  marks;
    }
}

class Assignment33{
    public static void main(String[] args) {
        String string1 = "I like Python";
        String string2 = "Java is a very popular language";
        System.out.println(commonChars(string1, string2));
    }
    public static String commonChars(String string1, String string2){
        string1 = string1.toLowerCase(Locale.ROOT).replaceAll("\\s", "");
        string2 = string2.toLowerCase(Locale.ROOT).replaceAll("\\s", "");

        String commonChars = "";

        // can go for smaller string but whatever
        for(int i =0; i< string1.length(); i++){
            if (string2.contains(String.valueOf(string1.charAt(i))) && !commonChars.contains(String.valueOf(string1.charAt(i)))){
                commonChars += string1.charAt(i);
            }
        }
        return commonChars.length() > 0 ?String.valueOf(commonChars): "-1" ;
    }
}

class Assignment30{
    public static String compressString(String str){
        char currentChar = str.charAt(0);
        String compressedString = "";
        int currentCharCount = 1;
        for (int i = 1; i< str.length(); i++){
            if (currentChar == str.charAt(i)){
                currentCharCount += 1;
            }else{
                compressedString += currentCharCount;
                compressedString += currentChar;
                currentCharCount = 1;
                currentChar = str.charAt(i);
            }



        }
        compressedString += currentCharCount;
        compressedString += currentChar;
        return compressedString;
    }
}


class Assignment28{
    public static int maxOfSpecialNoInRange(int num1, int num2){
        ArrayList<Integer> specialNOs = new ArrayList<>();

        for (int i = num1; i<= num2; i++){
            int sumOfDigits = 0;
            int copyOfi = i;
            while(copyOfi > 0){
                sumOfDigits += copyOfi %10;
                copyOfi /= 10;
            }
//            System.out.println(sumOfDigits);
            if (sumOfDigits % 3 == 0 || (i < 99 && i > 9) || i % 5 == 0) {
                specialNOs.add(i);
            }

        }
        if (specialNOs.size() > 0) {
            return Collections.max(specialNOs);
        }else {
            return -1;
        }
    }
}

class Assignment26{
    public static int[] chickensAndRabbits(int heads, int legs){

        for (int i = 0; i<= heads; i++){
            for (int j = 0; j<= heads-i; j++){
//                System.out.println("i :"+ i + " j :" + j);
                if(i + j == heads && ((i * 2) + (j * 4)) == legs){
                    return new int[]{i, j};
                }

            }
        }
        return new int[]{0,0};
    }
}

class Assignment25{
    public static void printStar(){
        int counter1=0;
        int counter2 = 5;
        while (counter1 < 5){
            String star = "";
            while(counter2 > counter1){
                star += "*";
                counter2 -= 1;
            }
            System.out.println(star);
            counter1 += 1;
            counter2 = 5;

        }
    }
}

class Assignment23{
    public static void testAssignment23(){
        ArrayList<String> gemList = new ArrayList<>(Arrays.asList("Emerald","Ivory","Jasper","Ruby","Garnet"));
        ArrayList<Integer> price_list = new ArrayList<>(Arrays.asList(1760,2119,1599,3920,3999));
        ArrayList<String> reqdGems = new ArrayList<>(Arrays.asList("Ivory","Emerald","Garnet"));
        ArrayList<Integer> reqdQantity = new ArrayList<>(Arrays.asList(3,10,12));
        double result = Assignment23.calculateBillAmount(gemList, price_list, reqdGems, reqdQantity);
        System.out.println(result);
    }
    public static double calculateBillAmount(ArrayList<String> gemList, ArrayList<Integer> priceList, ArrayList<String> reqdGems, ArrayList<Integer> reqdQuanitiy){
        double billAmount = 0;
        if (gemList.containsAll(reqdGems)){
            assert reqdGems.size() == reqdQuanitiy.size();
            for (int i = 0; i < reqdGems.size(); i++){
                billAmount += reqdQuanitiy.get(i) * priceList.get(gemList.indexOf(reqdGems.get(i)));
            }
            if (billAmount > 30000){
                billAmount = billAmount * .95;

            }
            return billAmount;
        }else{
            return  -1;
        }

    }
}



class Assignment21{
    public static void getNextDate(int day, int month, int year){
        boolean leap_year;
        if (year % 400 == 0) {
            leap_year = true;

        }else if(year % 100 == 0){
            leap_year = false;
        }else if (year % 4 == 0){
            leap_year = true;
        }else{
            leap_year = false;
        }
        int month_length;

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8|| month == 10|| month == 12){
            month_length = 31;
        }else if (month == 2){
            if (leap_year){
                month_length = 29;
            }else{
                month_length = 28;
            }
        }else{
            month_length = 30;
        }

        if (day < month_length){
            day += 1;
        }else{
            day = 1;
            if (month == 12){
                month =1;
                year += 1;

            }else{
                month += 1;
            }

        }
        System.out.println("The next date is (dd/mm/yy): " + day + "/" +month+ "/" + year);

    }
}

class MetroBank{


    public static void calculateLoan(int accountNo, double accountBalance, double salary, String loanType
    ,double loanAmountExpected, double customerEmiExpected ){
        if (accountNo< 1000 || accountNo > 1999 || accountBalance < 100000){
            System.out.println("Your account is not eligible");;
        }else{ //valid account
            if (loanType.equals("Car")){
                if (salary> 25000 && loanAmountExpected<500000 && customerEmiExpected< 36){

                    System.out.println("Account no: "+ accountNo + "\nEligible" + "\nRequested Amount :" + loanAmountExpected );
                }else{
                    if (salary < 25000){
                        System.out.println("Account no: "+ accountNo + "\nNot Eligible" + "\nLow salary" );
                    }if (loanAmountExpected> 500000){
                        System.out.println("Account no: "+ accountNo + "\nNot Eligible" + "\nLoan amount Must be less than 500000:" );
                    }if (customerEmiExpected > 36){
                        System.out.println("Account no: "+ accountNo + "\nNot Eligible" + "\nMaximum Emi available is 36" );
                    }
                }
            }
            else if (loanType.equals("House")){
                if (salary> 50000 && loanAmountExpected<6000000 && customerEmiExpected< 60){

                    System.out.println("Account no: "+ accountNo + "\nEligible" + "\nRequested Amount :" + loanAmountExpected );
                }else{
                    if (salary < 50000){
                        System.out.println("Account no: "+ accountNo + "\nNot Eligible" + "\nLow salary" );
                    }if (loanAmountExpected> 6000000){
                        System.out.println("Account no: "+ accountNo + "\nNot Eligible" + "\nLoan amount Too high:" );
                    }if (customerEmiExpected > 60){
                        System.out.println("Account no: "+ accountNo + "\nNot Eligible" + "\nMaximum Emi available is 60" );
                    }
                }
            }
            else if (loanType.equals("Business")){
                if (salary> 75000 && loanAmountExpected<7500000 && customerEmiExpected< 84){

                    System.out.println("Account no: "+ accountNo + "\nEligible" + "\nRequested Amount :" + loanAmountExpected );
                }else{
                    if (salary < 75000){
                        System.out.println("Account no: "+ accountNo + "\nNot Eligible" + "\nLow salary" );
                    }if (loanAmountExpected> 7500000){
                        System.out.println("Account no: "+ accountNo + "\nNot Eligible" + "\nLoan amount Must be less than 7500000:" );
                    }if (customerEmiExpected > 84){
                        System.out.println("Account no: "+ accountNo + "\nNot Eligible" + "\nMaximum Emi available is 84" );
                    }
                }
            }else{
                System.out.println(loanType + " loan Type of loan is not supported");
            }
        }
    }

}

class Assignment19{
    private static final int VEG_COMBO_RATE =  120;
    private static final int NON_VEG_COMBO_RATE = 150;
    public static double charges(String foodType, int noOfPlates, int distance){
        double deliveryCharge = deliveryCharges(distance);
        if (foodType != "V" && foodType != "N" || distance <= 0 || noOfPlates <= 0){
            return -1;
        }else{
            if (foodType.equals("V")){
                return VEG_COMBO_RATE + deliveryCharge;
            }else{
                return NON_VEG_COMBO_RATE + deliveryCharge;
            }
        }
    }

    private static double deliveryCharges(int distance){
        if (distance < 3){
            return 0;
        }else if(distance < 6){
            return (distance - 3)*3;
        }else{
            return (distance-6)*6 + 9;
        }
    }

}
class Assignment18{
    public static double convertCurrency(int amount, String toCurrency){
        if (toCurrency.equals("Euro")){
            return amount * 0.01417;
        }else if( toCurrency.equals("British Pound")){
            return amount * 0.0100;
        }else if(toCurrency.equals("Australian Dollar")){
            return amount * 0.2140;
        }else if(toCurrency.equals("Canadian Dollar")){
            return amount * 0.02027;
        }else{
            return amount;
        }
    }
}


class Assignment17{

    public static double findNewSalary(int oldSalary, int jobLevel){
        if (jobLevel == 3) {
            return oldSalary * 1.15;
        }else if(jobLevel == 4){
            return  oldSalary * 1.07;
        }else if(jobLevel  == 5){
            return oldSalary * 1.05;
        }else{
            return oldSalary;
        }

    }
}
