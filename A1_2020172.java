import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


class Slot {
    Vaccine vaccineOfSlot;
    int dayNum;
    int vaccineQuantity;

    Slot(Vaccine vaccineOfSlot, int dayNum, int vaccineQuantity) {
        this.vaccineOfSlot = vaccineOfSlot;
        this.dayNum = dayNum;
        this.vaccineQuantity = vaccineQuantity;
    }

}

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

class AllVaccines {

    ArrayList<Vaccine> vaccineList = new ArrayList<Vaccine>(); 

    void addition(String vaccineName, int noOfDoses, int gap) {        
        vaccineList.add(new Vaccine(vaccineName, noOfDoses, gap));
        System.out.println("Vaccine Name: "+vaccineName +", Number of Doses: "+noOfDoses+", Gap Between Doses: "+gap);
    }

}

class Citizen {
    String citizenName;
    Integer age;
    Long uniqueID;
    String vaccinationStatus;
    int noOfDosesGiven;
    Vaccine givenVac;

    Citizen(String citizenName, Integer age, Long uniqueID) {
        this.citizenName = citizenName;
        this.age = age;
        this.uniqueID = uniqueID;
    }
}

class AllCitizens {

    ArrayList<Citizen> citizenList = new ArrayList<Citizen>();
    
    void registration(String citizenName, int age, Long uniqueID) {
        Citizen toBeAdded = new Citizen(citizenName, age, uniqueID);
        toBeAdded.vaccinationStatus  = "REGISTERED";
        citizenList.add(toBeAdded);
        System.out.println("Citizen Name: "+citizenName+", Age: "+age+", Unique ID: "+uniqueID);
    }

    String[] bookSlot(Long citizenID, Vaccine regVac) {
        String[] name_vacName = new String[2];
        for (int i = 0; i < citizenList.size(); i++) {
            if (citizenID == citizenList.get(i).uniqueID) {
                Citizen temp = citizenList.get(i);
                temp.givenVac = regVac;
                temp.vaccinationStatus = "PARTIALLY VACCINATED";
                temp.noOfDosesGiven++;
                if (regVac.noOfDoses == 1) {
                    temp.vaccinationStatus = "FULLY VACCINATED";
                }
                citizenList.set(i, temp);
                name_vacName[0] = temp.citizenName;
                name_vacName[1] = temp.givenVac.vaccineName;
                break;
            }
        }
        return name_vacName;
    }
}

class Hospital {
    String hospitalName;
    int pincode;
    int uniquehID;

    ArrayList<Slot> listOfSlots = new ArrayList<Slot>();

    Hospital(String hospitalName, int pincode) {
        Random random = new Random();
        this.hospitalName = hospitalName;
        this.pincode = pincode;
        this.uniquehID = random.nextInt(1000000);
    }

    void slotCreation(Vaccine vaccineToBeAdded, int dayNum, int quantity) {
        Slot slotCreated = new Slot(vaccineToBeAdded, dayNum, quantity);
        listOfSlots.add(slotCreated);
    }
}

class AllHospitals {

    ArrayList<Hospital> hospitalList = new ArrayList<Hospital>();

    void registration(String hospitalName, int pincode) {
        Hospital toBeAdded = new Hospital(hospitalName, pincode);
        hospitalList.add(toBeAdded);
        System.out.println("Hospital Name: "+hospitalName+", PinCode: "+pincode+", UniqueID: "+toBeAdded.uniquehID);
    }

    void slotAdditionWithID(Vaccine vaccineToBeAdded, int inputID, int dayNum, int quantity) {
        Hospital temp;
        for (int i = 0; i < hospitalList.size(); i++) {
            int x = hospitalList.get(i).uniquehID;
            if (x == inputID) {
                temp = hospitalList.get(i);
                temp.slotCreation(vaccineToBeAdded, dayNum, quantity);
                hospitalList.set(i, temp);
                break;
            }
        }
        System.out.println("Slot added by Hospital "+inputID+" for Day : "+dayNum+", Available Quantity: "+quantity+" of Vaccine "+vaccineToBeAdded.vaccineName);
    }

    void listHospitalsWithPinCode(int pincode) {
        for (int i = 0; i < hospitalList.size(); i++) {
            if (hospitalList.get(i).pincode == pincode) {
                System.out.println(hospitalList.get(i).uniquehID+" "+hospitalList.get(i).hospitalName);
            }
        }
    }

    Vaccine[] listSlotsfor5(int hospitalID) {
        Vaccine[] vaccinesReturned = new Vaccine[0];
        for (int i = 0; i < hospitalList.size(); i++) {
            if (hospitalList.get(i).uniquehID == hospitalID) {
                ArrayList<Slot> temp = hospitalList.get(i).listOfSlots;
                vaccinesReturned = new Vaccine[temp.size()];
                for (int j = 0; j < temp.size(); j++) {
                    System.out.println(j+"-> Day: "+temp.get(j).dayNum+", Available Qty: "+temp.get(j).vaccineQuantity+", Vaccine: "+temp.get(j).vaccineOfSlot.vaccineName);
                    vaccinesReturned[j] = temp.get(j).vaccineOfSlot;
                }
                break;
            }
        }
        return vaccinesReturned;
    }

    void listSlotsOnly(int hospitalID) {
        for (int i = 0; i < hospitalList.size(); i++) {
            if (hospitalList.get(i).uniquehID == hospitalID) {
                ArrayList<Slot> temp = hospitalList.get(i).listOfSlots;
                for (int j = 0; j < temp.size(); j++) {
                    System.out.println("Day: "+temp.get(j).dayNum+", Vaccine: "+temp.get(j).vaccineOfSlot.vaccineName+", Available Qty: "+temp.get(j).vaccineQuantity);
                }
                break;
            }
        }
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
                if (age < 18) {
                    System.out.println("Only above 18 are allowed");
                } else {
                    citizenList.registration(citizenName, age, citizenID);
                }

            } else if (queryNo == 4) {

                System.out.print("Enter Hospital ID: ");
                int hospitalID = Integer.parseInt(in.nextLine());
                System.out.print("Enter number of Slots to be added: ");
                int noOfSlots = Integer.parseInt(in.nextLine());
                for (int i = 0; i < noOfSlots; i++) {
                    System.out.print("Enter Day Number: ");
                    int dayNum = Integer.parseInt(in.nextLine());
                    System.out.print("Enter Quantity: ");
                    int quantity = Integer.parseInt(in.nextLine());
                    System.out.println("Select Vaccine");
                    for (int j = 0; j < vaccineList.vaccineList.size(); j++) {
                        System.out.println(j+". "+vaccineList.vaccineList.get(j).vaccineName);
                    }
                    int vaccineIndex = Integer.parseInt(in.nextLine());
                    Vaccine vaccineToBeAdded = vaccineList.vaccineList.get(vaccineIndex);
                    hospitalList.slotAdditionWithID(vaccineToBeAdded, hospitalID, dayNum, quantity);
                }

            } else if (queryNo == 5) {

                System.out.print("Enter patient Unique ID: ");
                Long uniqueID = Long.parseLong(in.nextLine());
                System.out.println("1. Search by area");
                System.out.println("2. Search by Vaccine");
                System.out.println("3. Exit");
                System.out.print("Enter option: ");
                int option = Integer.parseInt(in.nextLine());

                if (option == 1) {
                    System.out.print("Enter PinCode: ");
                    int areaID = Integer.parseInt(in.nextLine());
                    hospitalList.listHospitalsWithPinCode(areaID);
                    System.out.println("Enter Hospital ID: ");
                    int hospitalID = Integer.parseInt(in.nextLine());
                    Vaccine[] returned = hospitalList.listSlotsfor5(hospitalID);
                    System.out.print("Choose Slot: ");
                    int slotNo = Integer.parseInt(in.nextLine());
                    String[] name_vacName = citizenList.bookSlot(uniqueID, returned[slotNo]);
                    System.out.println(name_vacName[0]+" vaccinated with "+name_vacName[1]);

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
                hospitalList.listSlotsOnly(hospitalID);

            } else if (queryNo == 7) {

                System.out.print("Enter patient Unique ID: ");
                Long uniqueID = Long.parseLong(in.nextLine());
                Citizen temp;
                String vacName = "a";
                String status = "a";
                Integer dosesNo = 0;
                Integer duedate = 0;
                for (int i = 0; i < citizenList.citizenList.size(); i++) {
                    if (citizenList.citizenList.get(i).uniqueID == uniqueID) {
                        temp = citizenList.citizenList.get(i);
                        vacName = temp.givenVac.vaccineName;
                        status = temp.vaccinationStatus;
                        dosesNo = temp.noOfDosesGiven;
                        duedate = temp.givenVac.gap+1;
                        break;
                    }
                }
                System.out.println(status);
                System.out.println("Vaccine Given: "+vacName);
                System.out.println("Number of Doses given: "+dosesNo);
                if (!status.equals("FULLY VACCINATED")) {
                    System.out.println("Next Dose due date: "+duedate);
                }

            } else {
                System.out.println("Incorrect menu option");
            }
            menu();
            queryNo = Integer.parseInt(in.nextLine());
        }
        in.close();
    }
}