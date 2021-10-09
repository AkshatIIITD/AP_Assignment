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
                String vaccineName = in.nextLine();
                System.out.print("Number of Doses: ");
                int noOfDoses = Integer.parseInt(in.nextLine());
                int gap = 0;
                if (noOfDoses > 1) {
                    System.out.print("Gap Between Doses: ");
                    gap = Integer.parseInt(in.nextLine());
                }
                vaccines.addition(vaccineName, noOfDoses, gap);

            } else if (queryNo == 2) {
                System.out.print("Hospital Name: ");
                String hospitalName = in.nextLine();
                System.out.print("PinCode: ");
                int pincode = Integer.parseInt(in.nextLine());
                hospitals.registration(hospitalName, pincode);

            } else if (queryNo == 3) {
                System.out.print("Citizen Name: ");
                String citizenName = in.nextLine();
                System.out.print("Age: ");
                int age = Integer.parseInt(in.nextLine());
                System.out.print("Unique ID: ");
                int citizenID = Integer.parseInt(in.nextLine());
                if (age < 19) {
                    System.out.println("Only above 18 are allowed");
                } else {
                    citizen.registration(citizenName, age, citizenID);
                }

            } else if (queryNo == 4) {
                System.out.println("Enter Hospital ID: ");
                int hospitalID = Integer.parseInt(in.nextLine());
                System.out.print("Enter number of Slots to be added: ");
                int noOfSlots = Integer.parseInt(in.nextLine());
                System.out.print("Enter Day Number: ");
                int dayNum = Integer.parseInt(in.nextLine());
                System.out.print("Enter Quantity: ");
                int quantity = Integer.parseInt(in.nextLine());
                

            } else if (queryNo == 5) {
                System.out.print("Enter patient Unique ID: ");
                int uniqueID = Integer.parseInt(in.nextLine());
                System.out.println("1. Search by area");
                System.out.println("2. Search by Vaccine");
                System.out.println("3. Exit");
                System.out.print("Enter option: ");
                int option = Integer.parseInt(in.nextLine());
                
                if (option == 1) {
                    System.out.print("Enter PinCode: ");
                    int areaID = Integer.parseInt(in.nextLine());
                    //list hospitalIDs and hospitals here. 
                    System.out.println("Enter Hospital ID: ");
                    int hospitalID = Integer.parseInt(in.nextLine());
                    //
                    //
                    System.out.print("Choose Slot: ");
                    int slotNo = Integer.parseInt(in.nextLine());
                    //
                    System.out.println(" vaccinated with ");

                } else if (option == 2) {
                    System.out.print("Enter Vaccine Name");
                    String vaccineName = in.nextLine();
                    //list hospitalIDs and hospitals here. 
                    System.out.println("Enter Hospital ID: ");
                    int hospitalID = Integer.parseInt(in.nextLine());
                    //
                    //
                    System.out.print("Choose Slot: ");
                    int slotNo = Integer.parseInt(in.nextLine());
                    //
                    System.out.println(" vaccinated with ");                    

                } else if (option == 3) {
                    continue;
                } else {
                    System.out.println("Wrong Option");
                }

            } else if (queryNo == 6) {
                System.out.println("Enter Hospital ID: ");
                int hospitalID = Integer.parseInt(in.nextLine());
                //list all slots

            } else if (queryNo == 7) {
                System.out.print("Enter patient Unique ID: ");
                int uniqueID = Integer.parseInt(in.nextLine());
                //status
                System.out.println("Vaccine Given: ");
                System.out.println("Number of Doses given: ");
                
            } else {
                System.out.println("Incorrect menu option");
            }
            menu();
            queryNo = Integer.parseInt(in.nextLine());
        }
        in.close();
    }
}