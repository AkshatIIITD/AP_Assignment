import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


class Slot {
    
}

class AllVaccines {

    class Vaccine{
        String vaccineName;
        int noOfDoses;
        int gap;
    
        Vaccine(String vaccineName, int noOfDoses, int gap) {
            this.vaccineName = vaccineName;
            this.noOfDoses = noOfDoses;
            this.gap = gap;
        }
    }

    ArrayList<Vaccine> vaccineList = new ArrayList<Vaccine>(); 

    void addition(String vaccineName, int noOfDoses, int gap) {        
        vaccineList.add(new Vaccine(vaccineName, noOfDoses, gap));
        System.out.println("Vaccine Name: "+vaccineName +", Number of Doses: "+noOfDoses+", Gap Between Doses: "+gap);
    }

}

class AllCitizens {

    class Citizen {
        String citizenName;
        Integer age;
        Long uniqueID;
        String vaccinationStatus;

        Citizen(String citizenName, Integer age, Long uniqueID) {
            this.citizenName = citizenName;
            this.age = age;
            this.uniqueID = uniqueID;
        }
    }

    ArrayList<Citizen> citizenList = new ArrayList<Citizen>();
    
    void registration(String citizenName, int age, Long uniqueID) {
        Citizen toBeAdded = new Citizen(citizenName, age, uniqueID);
        toBeAdded.vaccinationStatus  = "REGISTERED";
        citizenList.add(toBeAdded);
        System.out.println("Citizen Name: "+citizenName+", Age: "+age+", Unique ID: "+uniqueID);
    }

    void changeStatus() {

    }
}


class AllHospitals {
    
    class Hospital {
        String hospitalName;
        int pincode;
        int uniquehID;
    
        Hospital(String hospitalName, int pincode) {
            Random random = new Random();
            this.hospitalName = hospitalName;
            this.pincode = pincode;
            this.uniquehID = random.nextInt(1000000);
        }
    }

    ArrayList<Hospital> hospitalList = new ArrayList<Hospital>();

    void registration(String hospitalName, int pincode) {
        Hospital toBeAdded = new Hospital(hospitalName, pincode);
        hospitalList.add(toBeAdded);
        System.out.println("Hospital Name: "+hospitalName+", PinCode: "+pincode+", UniqueID: "+toBeAdded.uniquehID);
    }

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
        AllVaccines vaccineList = new AllVaccines();
        AllHospitals hospitalList = new AllHospitals();
        AllCitizens citizenList = new AllCitizens();
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
                vaccineList.addition(vaccineName, noOfDoses, gap);
                

            } else if (queryNo == 2) {
                System.out.print("Hospital Name: ");
                String hospitalName = in.nextLine();
                System.out.print("PinCode: ");
                int pincode = Integer.parseInt(in.nextLine());
                hospitalList.registration(hospitalName, pincode);

            } else if (queryNo == 3) {
                System.out.print("Citizen Name: ");
                String citizenName = in.nextLine();
                System.out.print("Age: ");
                int age = Integer.parseInt(in.nextLine());
                System.out.print("Unique ID: ");
                Long citizenID = Long.parseLong(in.nextLine());
                if (age < 19) {
                    System.out.println("Only above 18 are allowed");
                } else {
                    citizenList.registration(citizenName, age, citizenID);
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