import java.util.Scanner;


class Hospitals {
    
    
    void registration(String name, int pincode) {

    }
}

class Citizen {

    void registration(String name, int age, int id) {

    }


}

class Slot {
    
}

public class akshat {
    public static void main(String[] args) {
        System.out.println("CoWin Portal initialized....");
        System.out.println("---------------------------------");
        System.out.println("1. Add Vaccine");
        System.out.println("2. Register Hospital");
        System.out.println("3. Register Citizen");
        System.out.println("4. Add Slot for Vaccination");
        System.out.println("5. Book Slot for Vaccination");
        System.out.println("6. List all slots for a Hospital");
        System.out.println("7. Check Vaccination Status");
        System.out.println("8. Exit");
        System.out.println("---------------------------------");
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int queryNo = Integer.parseInt(in.nextLine());
            if (queryNo == 1) {

            } else if (queryNo == 2) {

            } else if (queryNo == 3) {

            } else if (queryNo == 4) {

            } else if (queryNo == 5) {

            } else if (queryNo == 6) {

            } else if (queryNo == 7) {

            } else if (queryNo == 8) {

            } else {
                System.out.println("Incorrect menu option");
            }
        }
        in.close();
    }
}