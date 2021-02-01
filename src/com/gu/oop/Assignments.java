package com.gu.oop;

import java.util.*;

public class Assignments {
    public static void main(String[] args) {


    }
}

class Assignment22{
    public static void main(String[] args) {
        Multiplex booking1 = new Multiplex();

        int status = booking1.bookTicket("Movie1", 10);
        switch (status){
            case -1:
                System.out.println("Tickets not available for movie-1");
                break;
            case 0:
                System.out.println("invalid movie name");
                break;
            default:
                System.out.println("Booking successful");
                System.out.println("Seat numbers: "+ booking1.getSeatNumbers());
                System.out.println("Total amount to be paid: "+ booking1.getTotalPrice());
        }
        Multiplex booking2 = new Multiplex();
        int stat = booking2.bookTicket("Movie2", 6);
        switch (stat){
            case -1:
                System.out.println("Tickets not available for movie-1");
                break;
            case 0:
                System.out.println("invalid movie name");
                break;
            default:
                System.out.println("Booking successful");
                System.out.println("Seat numbers: "+ booking2.getSeatNumbers());
                System.out.println("Total amount to be paid: "+ booking2.getTotalPrice());
        }
    }



}
class Multiplex{
    private static ArrayList<String> movieNameList = new ArrayList<>(Arrays.asList("Movie1", "Movie2"));
    private static ArrayList<Integer> totalTicketsList = new ArrayList<>(Arrays.asList(100, 60));
    private static ArrayList<Double> ticketPriceList = new ArrayList<>(Arrays.asList(150.0, 200.0));
    private static ArrayList<Integer> lastSeatNumberList = new ArrayList<>(Arrays.asList(0,0));
    private ArrayList<String> seatNumbers;
    private double totalPrice;

    public Multiplex() {
    }
    public void generateSeatNumber(int movieIndex, int numberOfTickets){
        ArrayList<String> seatNumbers = new ArrayList<>();
        if (checkSeatAvailability(movieIndex, numberOfTickets)){

            int startingIndex = lastSeatNumberList.get(movieIndex)==0?
                    1: lastSeatNumberList.get(movieIndex);
            int i;
            for (i = startingIndex ; i<= numberOfTickets; i++){
                seatNumbers.add("M"+ (movieIndex+1) + "-" + i);
            }

            totalTicketsList.add(movieIndex, totalTicketsList.get(movieIndex)-numberOfTickets);
            lastSeatNumberList.add(movieIndex, i);
        }

        this.seatNumbers = seatNumbers;


    }
    public boolean checkSeatAvailability(int movieIndex, int numberOfTickets){
        return totalTicketsList.get(movieIndex) >= numberOfTickets;

    }
    public void calculateTicketPrice(int movieIndex, int numberOfTickets){
        this.totalPrice = ticketPriceList.get(movieIndex) * numberOfTickets;
    }
    public int bookTicket(String movieName, int numberOfTickets){
        if (!movieNameList.contains(movieName)){
            return 0;
        }else{
            int movieIndex = movieNameList.indexOf(movieName);
            if (numberOfTickets > totalTicketsList.get(movieIndex)){
                return -1;
            }else{
                generateSeatNumber(movieIndex, numberOfTickets);
                calculateTicketPrice(movieIndex, numberOfTickets);
                return 1;

            }
        }

    }

    public ArrayList<String> getSeatNumbers() {
        return seatNumbers;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
class Assignment21{
    public static void main(String[] args) {
        ArrayList<Integer> tests =new ArrayList<Integer>(Arrays.asList(1001,2001,3001));
        Patient p1 = new Patient(232,"Saumya", tests);
        p1.calculateLabTestCharge();
        System.out.println(p1.getLabTestCharge());
    }
}

class Patient{
    private int patientId;
    private String patientName;
    private ArrayList<Integer> listOfLabTestIds;
    private double labTestCharge;

    public Patient(int patientId, String patientName, ArrayList<Integer> listOfLabTestIds){
        this.patientId = patientId;
        this.patientName = patientName;
        this.listOfLabTestIds = listOfLabTestIds;
    }

    public void calculateLabTestCharge(){
        LapTestRepository  testRepository = new LapTestRepository();
        double totalcharge = 0;
        for (Integer id : listOfLabTestIds){
            totalcharge += testRepository.getLabTestCharge(id);
        }
        this.labTestCharge = totalcharge;

    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public ArrayList<Integer> getListOfLabTestIds() {
        return listOfLabTestIds;
    }

    public double getLabTestCharge() {
        return labTestCharge;
    }
}

class LapTestRepository{
    private static ArrayList<Integer> hospitalLabTestIds = new ArrayList<>(Arrays.asList(1001,2001,3001,4001));
    private static ArrayList<Double> labTestCharges = new ArrayList<>(Arrays.asList(100.0,200.0,300.0,400.0));

    public Double getLabTestCharge(Integer labTestId){
        if (hospitalLabTestIds.contains(labTestId)){
            return labTestCharges.get(hospitalLabTestIds.indexOf(labTestId));
        }
        else {
            return 0.0;
        }
    }

}

class Assignment20{
    public static void main(String[] args) {
        Applicant saumya = new Applicant("Saumya");
        System.out.println(saumya.applyForJob("Software Engineering"));
        Applicant gaurav = new Applicant("Gaurav");
        System.out.println(gaurav.applyForJob("CSE"));
        saumya.applyForJob("Software Engineering");
        saumya.applyForJob("Software Engineering");
        saumya.applyForJob("Software Engineering");
        saumya.applyForJob("Software Engineering");
        saumya.applyForJob("Software Engineering");
        System.out.println(saumya.applyForJob("Software Engineering"));

        System.out.println(saumya);
        System.out.println(gaurav);

    }
}
class Applicant{
    private static HashMap<String, Integer> applicationDict = new HashMap<>();
    private static int applicantIdCount = 1000;
    private int applicantId;
    private String applicantName;
    private String jobBand;

    public Applicant(String applicantName) {
        this.applicantName = applicantName;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "applicantId=" + applicantId +
                ", applicantName='" + applicantName + '\'' +
                ", jobBand='" + jobBand + '\'' +
                '}';
    }

    public void generateApplicantId(){
        applicantId = ++applicantIdCount;
    }
    public int applyForJob(String jobBand){
        if (!applicationDict.containsKey(jobBand)){
            applicationDict.put(jobBand, 1);
            generateApplicantId();
            this.jobBand = jobBand;
            return 1;

        }else if(applicationDict.get(jobBand) <5){
            applicationDict.put(jobBand, applicationDict.get(jobBand)+1);
            generateApplicantId();
            this.jobBand = jobBand;
            return 1;

        }else{
            return - 1;
        }
    }

    public static HashMap<String, Integer> getApplicationDict() {
        return applicationDict;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public String getJobBand() {
        return jobBand;
    }
}

class Assignment19{
    public static void main(String[] args) {
        Ticket ticket = new Ticket("saumya", "delhi", "mumbai");
        ticket.generateTicket();
        Ticket ticket1 = new Ticket("gaurav", "Delhi", "Patna");
        ticket1.generateTicket();
        Ticket ticket2 = new Ticket("saurabh", "mumbai", "kolkata");
        ticket2.generateTicket();

        System.out.println(ticket);
        System.out.println(ticket1);
        System.out.println(ticket2);

    }

}

class Ticket{
    private String passengerName;
    private String ticketId;
    private String source;
    private String destination;
    public static int counter = 1;

    @Override
    public String toString() {
        return "Ticket{" +
                "passengerName='" + passengerName + '\'' +
                ", ticketId='" + ticketId + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }

    public Ticket(String passengerName, String source, String destinamtion) {
        this.passengerName = passengerName;
        this.source = source.toLowerCase();
        this.destination = destinamtion.toLowerCase();

    }
    public boolean validateSourceDestination(){
        ArrayList<String> destinations = new ArrayList<>(Arrays.asList("mumbai", "chennai", "pune", "kolkata"));
        return source.equals("delhi") && destinations.contains(destination);
    }

    public void generateTicket(){
        if(validateSourceDestination()){
            ticketId = String.valueOf(source.charAt(0)).toUpperCase()+String.valueOf(destination.charAt(0)).toUpperCase();
            if(counter < 10){
                ticketId +="0"+counter;
            }else{
                ticketId += counter;
            }
            counter++;
        }else {
            this.ticketId = "None";

        }


    }


    public String getTicketId() {
        return ticketId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
}
class Assignment18{
    public static void main(String[] args) {
        Customer customer = new Customer("Saumya");
        Item milk = new Item(2332,"Milk", 30.0);
        Item bread = new Item(2333, "Bread", 25.0);

        HashMap<Integer, Integer> item_quantity = new HashMap<>();
        item_quantity.put(2332, 20);
        item_quantity.put(2333, 10);

        ArrayList<Item> items = new ArrayList<>();
        items.add(milk);
        items.add(bread);

        Bill bill = new Bill();
        bill.generateBillAmount(item_quantity, items);
        customer.paysBill(bill);

        Bill bill1 = new Bill();
        item_quantity.remove(2332);
        bill1.generateBillAmount(item_quantity, items);
        customer.paysBill(bill1);
    }
}
class Customer{
    private String customerName;
    private String paymentStatus;

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public void paysBill(Bill bill){
        paymentStatus = "Paid";
        System.out.println("Customer Name :"+ customerName + "\nBill Id: "+ bill.getBillId()
                + "\nBill Amount: "+ bill.getBillAmount());

    }
}
class Bill{
    private String billId;
    private double billAmount;
    public static int counter = 1000;

    public Bill() {
    }
    public void generateBillAmount(HashMap<Integer, Integer> itemQuantity, ArrayList<Item> items){
        billId = "B" + counter;
        double total = 0;
        for (Integer itemId : itemQuantity.keySet()){
            for (Item item : items){
                if(item.getItemId() == itemId){
                    total += itemQuantity.get(itemId) *item.getPricePerQuantity();

                }

            }

        }
        billAmount = total;

    }

    public double getBillAmount() {
        return billAmount;
    }

    public String getBillId() {
        return billId;
    }
}

class Item{
    private int itemId;
    private String description;
    private double pricePerQuantity;

    public Item(int itemId, String description, double pricePerQuantity) {
        this.itemId = itemId;
        this.description = description;
        this.pricePerQuantity = pricePerQuantity;
    }

    public int getItemId() {
        return itemId;
    }

    public String getDescription() {
        return description;
    }

    public double getPricePerQuantity() {
        return pricePerQuantity;
    }
}

//
//class Assignment17{
//    public static void main(String[] args) {
//        Customer c1 = new Customer("133232", "Saumya", "India");
//        Customer c2 = new Customer("1343333", "Elizabeth", "London");
//
//        Freight freight = new Freight(c2, c1, 25.0, 4000.0);
//
//        freight.forward_cargo();
//
//        System.out.println("Freight Id: " +freight.getFreightId() + " and Freight Charge: "+ freight.getFreight_charge() );
//
//
//
//    }
//
//}
//
//class Customer{
//    private String customerId;
//    private String customerName;
//    private String address;
//
//    public Customer(String customerId, String customerName, String address) {
//        this.customerId = customerId;
//        this.customerName = customerName;
//        this.address = address;
//    }
//
//    public boolean validateCustomer(){
//        return this.customerId.length() >= 6 && String.valueOf(customerId).charAt(0) == '1';
//    }
//
//    public String getCustomerId() {
//        return customerId;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//}
//
//class Freight{
//    private String freightId;
//    private Customer recipientCustomer;
//    private Customer fromCustomer;
//    private double weight;
//    private double distance;
//    private double freight_charge;
//    public static int counter = 200;
//
//    public Freight(Customer recipientCustomer, Customer fromCustomer, double weight, double distance) {
//        this.recipientCustomer = recipientCustomer;
//        this.fromCustomer = fromCustomer;
//        this.weight = weight;
//        this.distance = distance;
//    }
//    public boolean validateWeight(){
//        return weight % 5 == 0.0;
//    }
//
//    public boolean validateDistance(){
//        return distance >= 500 && distance <= 5000;
//    }
//    public void forward_cargo(){
//        if (fromCustomer.validateCustomer() &&
//        recipientCustomer.validateCustomer() &&
//        validateDistance() && validateWeight()) {
//            freightId = String.valueOf(counter);
//            counter += 2;
//
//            freight_charge =( weight * 150) + (distance * 60);
//        }else{
//            freight_charge = 0;
//        }
//    }
//
//    public double getFreight_charge() {
//        return freight_charge;
//    }
//
//    public String getFreightId() {
//        return freightId;
//    }
//
//    public Customer getRecipientCustomer() {
//        return recipientCustomer;
//    }
//
//    public Customer getFromCustomer() {
//        return fromCustomer;
//    }
//
//    public double getWeight() {
//        return weight;
//    }
//
//    public double getDistance() {
//        return distance;
//    }
//}

//class Assignment16{
//    public static void main(String[] args) {
//        ArrayList<CallDetail> callStringList = new ArrayList<>();
//        callStringList.add(new CallDetail("9990000001","9330000001","23","STD"));
//        callStringList.add(new CallDetail("9990000001","9330000002","54","Local"));
//        callStringList.add(new CallDetail("9990000001","9330000003","6","ISD"));
//
//        Customer c1 = new Customer("9990000001", "Saumya",88);
//        Customer c2 = new Customer("9990000002", "saurabh", 33);
//
//        List<Customer> customerList = new ArrayList<>(Arrays.asList(c1, c2));
//
//        Util util = new Util();
//        util.parseCustomer(customerList, callStringList);
//
//        System.out.println("Customer{" +
//                "phoneNo='" + c1.getPhoneNo() + '\'' + "\n"+
//                ", name='" + c1.getName() + '\'' +"\n"+
//                ", age=" + c1.getAge() +"\n"+
//                ", callList=" + c1.getCallList() +"\n"+
//                '}');
//        System.out.println("Customer{" +
//                "phoneNo='" + c2.getPhoneNo() + '\'' +"\n"+
//                ", name='" + c2.getName() + '\'' +"\n"+
//                ", age=" + c1.getAge() +"\n"+
//                ", callList=" + c1.getCallList() +"\n"+
//                '}');
//
//    }
//}
//
//class CallDetail{
//    private String phoneNo;
//    private String calledNo;
//    private String duration;
//    private String callType;
//
//    public CallDetail(String phoneNo, String calledNo, String duration, String callType) {
//        this.phoneNo = phoneNo;
//        this.calledNo = calledNo;
//        this.duration = duration;
//        this.callType = callType;
//    }
//
//    public String getPhoneNo() {
//        return phoneNo;
//    }
//
//    @Override
//    public String toString() {
//        return "CallDetail{" +
//                "phoneNo='" + phoneNo + '\'' +
//                ", calledNo='" + calledNo + '\'' +
//                ", duration='" + duration + '\'' +
//                ", callType='" + callType + '\'' +
//                '}';
//    }
//}
//
//class Customer{
//    private String phoneNo;
//    private String name;
//    private int age;
//    private ArrayList<CallDetail> callList;
//
//    public Customer(String phoneNo, String name, int age) {
//        callList = new ArrayList<>();
//        this.phoneNo = phoneNo;
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getPhoneNo() {
//        return phoneNo;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public ArrayList<CallDetail> getCallList() {
//        return callList;
//    }
//
//    public void setCallList(ArrayList<CallDetail> callList) {
//        this.callList = callList;
//    }
//
//
//}

//class Util{
//    ArrayList<Customer> customerCallDetailList; ;
//
//    public Util() {
//        this.customerCallDetailList = new ArrayList<>();
//    }
//
//    public void parseCustomer(List<Customer> customers, ArrayList<CallDetail> callList){
//
//        for (Customer customer : customers){
//            ArrayList<CallDetail> list = new ArrayList<>();
//            for (CallDetail callDetail : callList){
//                if (callDetail.getPhoneNo().equals(customer.getPhoneNo())){
//                    list.add(callDetail);
//                }
//            }
//            customer.setCallList(list);
//        }
//    }
//}
//
//class Parrot{
//    private static int counter = 7001;
//    private int uniqueNumber;
//    private String color;
//    private String name;
//
//
//
//    public Parrot(String color, String name) {
//        this.uniqueNumber = counter++;
//        this.color = color;
//        this.name = name;
//    }
//
//    public int getUniqueNumber() {
//        return uniqueNumber;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public String getName() {
//        return name;
//    }
//}
//class Classroom{
//    public static ArrayList<String> classroomList = new ArrayList<>(Arrays.asList("Bio", "Maths", "Science"));
//    public static String searchClassroom(String classRoom){
//        return classroomList.contains(classRoom) ? "Found" : "-1";
//    }
//
//}
//
//
//class Assignment12{
//    public static void main(String[] args) {
//
//        Bill bill = new Bill(123, "Saumya Kumar");
//
//        ArrayList<Integer> quantityList = new ArrayList<>(Arrays.asList(2,3,4,5));
//        ArrayList<Double> priceList = new ArrayList<>(Arrays.asList(3.0, 20.8, 99.8, 77.0));
//
//        bill.calculateBillAmount(500, quantityList, priceList);
//        System.out.println("Bill{" +
//                "billId=" + bill.getBillId() +
//                ", patientName='" + bill.getPatientName() + '\'' +
//                ", billAmount=" + bill.getBillAmount() +
//                '}');
//    }
//}
//
//class Bill{
//    private int billId;
//    private String patientName;
//    private double billAmount;
//
//
//
//
//    public Bill(int billId, String patientName) {
//        this.billId = billId;
//        this.patientName = patientName;
//    }
//
//    public int getBillId() {
//        return billId;
//    }
//
//    public String getPatientName() {
//        return patientName;
//    }
//
//    public double getBillAmount() {
//        return billAmount;
//    }
//    public  void calculateBillAmount(double consultationFees, ArrayList<Integer> quantityList, ArrayList<Double> priceList){
//        double billAmount = consultationFees;
//
//        try {
//            for (int i =0; i< quantityList.size(); i++){
//                billAmount += quantityList.get(i) * priceList.get(i);
//            }
//        }catch (IndexOutOfBoundsException e){
//            System.out.println("quantityList and PriceList must have same size");
//        }
//
//        this.billAmount = billAmount;
//    }
//}
//
//class Assignment11{
//    /***
//     * Royal Orchid is a florist. They want to be alerted when stock of a flower goes below a particular level.
//     * The flowers are identified using name, price per kg and stock available (in kgs).
//     * Write a Python program to implement the above requirement.
//     * @param args
//     */
//    public static void main(String[] args) {
//        Flower rose = new Flower();
//        rose.setFlowerName("Rose");
//        rose.setStockAvailable(100);
//        rose.setPricePerKg(40.0);
//        System.out.println(rose);
//        rose.sellFlower(5);
//        System.out.println(rose);
//
//
//    }
//
//    static class Flower{
//        private String flowerName;
//        private double pricePerKg;
//        private int stockAvailable;
//        private static HashMap<String, Integer> table =
//                new HashMap<>(Map.of("Orchid", 15, "Rose", 25, "Jasmine", 40));
//
//
//        public Flower() {
//
//        }
//
//        @Override
//        public String toString() {
//            return "Flower{" +
//                    "flowerName='" + flowerName + '\'' +
//                    ", pricePerKg=" + pricePerKg +
//                    ", stockAvailable=" + stockAvailable +
//                    '}';
//        }
//
//        boolean validateFlower(){
//
//
//            if (table.containsKey(this.flowerName)){
//                return true;
//            }else{
//                return false;
//            }
//        }
//
//        void sellFlower(int requiredQuantity){
//            if (validateFlower() && this.stockAvailable >= requiredQuantity){
//                this.stockAvailable -= requiredQuantity;
//            }
//
//        }
//
//        boolean checkLevel(){
//            return this.stockAvailable < table.get(this.flowerName);
//        }
//
//        public String getFlowerName() {
//            return flowerName;
//        }
//
//        public void setFlowerName(String flowerName) {
//            this.flowerName = flowerName;
//        }
//
//        public double getPricePerKg() {
//            return pricePerKg;
//        }
//
//        public void setPricePerKg(double pricePerKg) {
//            this.pricePerKg = pricePerKg;
//        }
//
//        public int getStockAvailable() {
//            return stockAvailable;
//        }
//
//        public void setStockAvailable(int stockAvailable) {
//            this.stockAvailable = stockAvailable;
//        }
//    }
//}
//
//class Assignment10{
//    public static void main(String[] args) {
//        String call="9990000001,9330000001,23,STD";
//        String call2="9990000001,9330000002,54,Local";
//        String call3="9990000001,9330000003,6,ISD";
//
//        ArrayList<String> callStringList = new ArrayList<>();
//        callStringList.add(call);
//        callStringList.add(call2);
//        callStringList.add(call3);
//
//        Util util = new Util();
//        util.parseCustomer(callStringList);
//
//        for (CallDetail cd : util.callDetailList){
//            System.out.println(cd);
//        }
//
//    }
//
//    static class CallDetail{
//        private String phoneNo;
//        private String calledNo;
//        private String duration;
//        private String callType;
//
//        public CallDetail(String phoneNo, String calledNo, String duration, String callType) {
//            this.phoneNo = phoneNo;
//            this.calledNo = calledNo;
//            this.duration = duration;
//            this.callType = callType;
//        }
//
//        @Override
//        public String toString() {
//            return "CallDetail{" +
//                    "phoneNo='" + phoneNo + '\'' +
//                    ", calledNo='" + calledNo + '\'' +
//                    ", duration='" + duration + '\'' +
//                    ", callType='" + callType + '\'' +
//                    '}';
//        }
//    }
//
//    static class Util{
//        ArrayList<CallDetail> callDetailList; ;
//
//        public Util() {
//            this.callDetailList = new ArrayList<>();
//        }
//
//        public void parseCustomer(ArrayList<String> callStringList){
//            ArrayList<CallDetail> list = new ArrayList<>();
//            for (String callString : callStringList){
//                String[] attributes  = callString.split(",");
//                list.add(new CallDetail(attributes[0], attributes[1], attributes[2], attributes[3]));
//            }
//            this.callDetailList = list;
//        }
//    }
//}
//
//
//
//class Assignment9{
//    // 8 me hi kar diya
//}
//
//class Assignment8{
//
//
//    public static void main(String[] args) {
//        Student st = new Student(1232);
//        st.setMarks(90);
//        st.setAge(23);
//
//        st.selectCourse(1002);
//        System.out.println(st);
//    }
//}
//
//class Student{
//    private int id;
//    private int age;
//    private double marks;
//    private int course;
//    private double fees;
//
//    public Student(int id) {
//        this.id = id;
//
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", age=" + age +
//                ", marks=" + marks +
//                ", course=" + course +
//                ", fees=" + fees +
//                '}';
//    }
//
//    private boolean validateMarks(double marks){
//       return marks > 0 && marks < 100;
//    }
//
//   private boolean validateAge(int age){
//        return age>20;
//   }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        if(validateAge(age)){
//            this.age = age;
//        }else{
//            System.out.println("Invalid age :"+ age);
//        }
//
//    }
//
//    public double getMarks() {
//        return marks;
//    }
//
//    public void setMarks(double marks) {
//        if (validateMarks(marks)){
//            this.marks = marks;
//        }else{
//            System.out.println("Invalid Marks: "+ marks);
//        }
//    }
//
//    boolean checkQualification(){
//        return age> 20 && marks >= 65;
//    }
//
//    void selectCourse(int id){
//        if(validateMarks(marks) && validateAge(age)){
//            if(id == 1001){
//                this.course = id;
//                if (marks> 85){
//                    System.out.println("You are eligible for 25% discount");
//                    this.fees = 25575.0 * 0.75;
//                }else{
//                    this.fees = 25575.0;
//                }
//
//            }else if(id == 1002){
//                this.course = id;
//                if (marks> 85){
//                    System.out.println("You are eligible for 25% discount");
//                    this.fees = 15500.0 * 0.75;
//                }else{
//                    this.fees = 15500.0;
//                }
//            }else{
//                System.out.println("Invalid Course selection "+ id);
//            }
//        }
//
//    }
//
//    public int getCourse() {
//        return course;
//    }
//
//    public double getFees() {
//        return fees;
//    }
//}
//
//
//
//
//
//class Assignment6and7{
//
//    public static void main(String[] args) {
//        ArrayList<String> skillList = new ArrayList<>();
//        skillList.add("Java");
//        skillList.add("Android");
//
//        double [] feedbacks = new double[]{5.0, 5.0, 4.5, 5.0, 5.0, 4.0};
//        Instructor instructor = new Instructor("Saurabh", skillList, 4, feedbacks );
//
//        System.out.println(instructor.allocateCourse("Java"));
//
//        System.out.println(instructor);
//    }
//
//
//}
//
//class Instructor{
//    private String name;
//    private ArrayList<String> techSkills;
//    private double experience;
//    private double[] feedbacks;
//    private String course;
//
//    public Instructor(String name, ArrayList<String> techSkills, double experience, double[] feedbacks) {
//        this.name = name;
//        this.techSkills = techSkills;
//        this.experience = experience;
//        this.feedbacks = feedbacks;
//    }
//
//    boolean checkEligibility(){
//        if (experience > 3 && calculateAvgFeedback() > 4.5){
//            return true;
//        }else if (experience <= 3 && calculateAvgFeedback() > 4){
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//    boolean allocateCourse(String technology){
//        if (techSkills.contains(technology) && checkEligibility()){
//            this.course = technology;
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//    double calculateAvgFeedback(){
//
//        double sum = 0.0;
//        for (double feedback : this.feedbacks){
//            sum += feedback;
//        }
//
//        return sum/this.feedbacks.length;
//
//    }
//
//    @Override
//    public String toString() {
//        return "Instructor{" +"\n"+
//                "name='" + name + '\'' + "\n"+
//                ", techSkills=" + techSkills + "\n"+
//                ", experience=" + experience +"\n"+
//                ", feedbacks=" + Arrays.toString(feedbacks) +"\n"+
//                ", course='" + course + '\'' +"\n"+
//                '}';
//    }
//}
//
//
//class Vehicle{
//    private String type;
//    private int id;
//    private double cost;
//    private double premiumAmount;
//
//    public Vehicle(int id) {
//
//        this.id = id;
//
//
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        if (type.equals("Two Wheeler")){
//            this.type = type;
//            this.premiumAmount = cost * 0.02;
//        }else if (type.equals("Six Wheeler")){
//            this.type = type;
//            this.premiumAmount = cost * 0.06;
//        }else{
//            this.premiumAmount = -1.0;
//            System.out.println("Wrong Type " + type);
//        }
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public double getCost() {
//        return cost;
//    }
//
//    public void setCost(double cost) {
//        this.cost = cost;
//    }
//
//    public double getPremiumAmount() {
//        return premiumAmount;
//    }
//}
//
//
//class Assignment4and5{
//
//
//    public static void main(String[] args) {
//        Vehicle vehicle1 = new Vehicle(123);
//        vehicle1.setCost(1232343.0);
//        vehicle1.setType("Two Wheeler");
//        System.out.println("Premium Amount : -" + vehicle1.getPremiumAmount());
//
//        Vehicle vehicle2 = new Vehicle(2343);
//        vehicle2.setCost(234343.0);
//        vehicle2.setType("adsklfja");
//        System.out.println("Premium Amount : -" + vehicle2.getPremiumAmount());
//    }
//
//
//
//}
//
//
//
//class Assignment123{
//
//
//
//    public static void main(String[] args) {
//        Item mango = new Item(1, "Juicy Fruit", 5.0);
//        Item Apple = new Item(2, "An apple a day keeps doctor away", 3.0);
//        ArrayList<Assignment123.Item> itemList = new ArrayList<>();
//        itemList.add(mango);
//        itemList.add(Apple);
//        Assignment123.Customer customer1 = new Customer("Saumya", itemList );
//
//        customer1.purchases();
//    }
//
//
//
//
//    static class Item{
//        public int item_id;
//        public String description;
//        public double pricePerUnit;
//
//        public Item(int item_id, String description, double pricePerUnit) {
//            this.item_id = item_id;
//            this.description = description;
//            this.pricePerUnit = pricePerUnit;
//        }
//    }
//
//    class Employee{
//        public String empName;
//        public String designation;
//
//    }
//
//     static class Customer{
//        public String customer_name;
//        public ArrayList<Item> purchasesList = new ArrayList<>();
//
//         public Customer(String customer_name, ArrayList<Item> purchasesList) {
//             this.customer_name = customer_name;
//             this.purchasesList = purchasesList;
//         }
//
//         public void paysBill(double amount){
//
//            System.out.printf("%s pays bill amount of Rs. %.2f", customer_name, amount);
//        }
//
//        public void purchases(){
//            double amount = 0;
//            for (Item item : purchasesList){
//                amount += item.pricePerUnit;
//            }
//
//            amount = amount*(0.95); // 5% discount
//
//            paysBill(amount);
//
//        }
//    }
//}