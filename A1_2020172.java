import java.util.Scanner;
import java.util.ArrayList;

class Hospitals {
    


    void registration(String name, int pincode) {

    }
}

class Citizen {

    void registration(String name, int age, int id) {

    }
}

class Vaccines {
    ArrayList<String> vaccineNameList = new ArrayList<String>(); 
    ArrayList<Integer> vaccineDosesList = new ArrayList<Integer>();
    ArrayList<Integer> vaccineGapList = new ArrayList<Integer>();

    void addition(String name, int noOfDoses, int gap) {
        vaccineNameList.add(name);
        vaccineDosesList.add(noOfDoses);
        vaccineGapList.add(gap);
    }
}

class Vaccine{
    String name;
    int noOfDoses;
    int gap;

    
}

class Slot {
    
}

public class A1_2020172 {
    public static void menu() {
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
    }

    public static void main(String[] args) {
        System.out.println("CoWin Portal initialized....");
        menu();
        Vaccines vaccines = new Vaccines();
        Hospitals hospitals = new Hospitals();
        Citizen citizen = new Citizen();
        Scanner in = new Scanner(System.in);
        int queryNo = Integer.parseInt(in.nextLine());
        while (queryNo != 8) {
            if (queryNo == 1) {
                System.out.print("Vaccine Name: ");
                String name = in.nextLine();
                System.out.print("Number of Doses: ");
                int noOfDoses = Integer.parseInt(in.nextLine());
                int gap = 0;
                if (noOfDoses > 1) {
                    System.out.print("Gap Between Doses: ");
                    gap = Integer.parseInt(in.nextLine());
                }
                vaccines.addition(name, noOfDoses, gap);

            } else if (queryNo == 2) {
                System.out.print("Hospital Name: ");
                String name = in.nextLine();
                System.out.print("PinCode: ");
                int pincode = Integer.parseInt(in.nextLine());
                hospitals.registration(name, pincode);

            } else if (queryNo == 3) {
                System.out.print("Citizen Name: ");
                String name = in.nextLine();
                System.out.print("Age: ");
                int age = Integer.parseInt(in.nextLine());
                System.out.print("Unique ID: ");
                int id = Integer.parseInt(in.nextLine());
                citizen.registration(name, age, id);

            } else if (queryNo == 4) {


            } else if (queryNo == 5) {


            } else if (queryNo == 6) {


            } else if (queryNo == 7) {


            } else if (queryNo == 8) {
                break;
            
            } else {
                System.out.println("Incorrect menu option");
            }
            queryNo = Integer.parseInt(in.nextLine());
        }
        in.close();
    }
}