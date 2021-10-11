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
    int nextDueDate = 1;
    Vaccine givenVac;


    Citizen(String citizenName, Integer age, Long uniqueID) {
        this.citizenName = citizenName;
        this.age = age;
        this.uniqueID = uniqueID;
        this.noOfDosesGiven = 0;
    }

}

class AllCitizens {

    ArrayList<Citizen> citizenList = new ArrayList<Citizen>();
    
    void registration(String citizenName, int age, Long uniqueID) {
        Citizen toBeAdded = new Citizen(citizenName, age, uniqueID);
        toBeAdded.givenVac = new Vaccine("nil", 0, 0);
        toBeAdded.vaccinationStatus = "REGISTERED";
        citizenList.add(toBeAdded);
        System.out.println("Citizen Name: "+citizenName+", Age: "+age+", Unique ID: "+uniqueID);
    }
    
    int bookSlot(Long citizenID, Vaccine regVac, int daynum) {
        int temp_index = 0;
        for (int i = 0; i < citizenList.size(); i++) {
            if (citizenID.equals(citizenList.get(i).uniqueID)) {
                Citizen tempCitizen = citizenList.get(i);
                if (daynum < tempCitizen.nextDueDate) {
                    return -1;
                }
                tempCitizen.givenVac = regVac;
                tempCitizen.vaccinationStatus = "PARTIALLY VACCINATED";
                tempCitizen.noOfDosesGiven++;
                tempCitizen.nextDueDate = tempCitizen.givenVac.gap + daynum;
                if (regVac.noOfDoses == tempCitizen.noOfDosesGiven) {
                    tempCitizen.vaccinationStatus = "FULLY VACCINATED";
                }
                citizenList.set(i, tempCitizen);
                temp_index = i;
                break;
            }
        }
        return temp_index;
    }
}

class Hospital {
    String hospitalName;
    int pincode;
    String uniquehID;

    ArrayList<Slot> listOfSlots = new ArrayList<Slot>();

    Hospital(String hospitalName, int pincode) {
        Random random = new Random();
        this.hospitalName = hospitalName;
        this.pincode = pincode;
        int uniqueno = random.nextInt(1000000);
        uniquehID = String.format("%06d", uniqueno);
    }

    int slotCreation(Vaccine vaccineToBeAdded, int dayNum, int quantity) {
        Boolean notPresent = true;
        for (int i = 0; i < listOfSlots.size(); i++) {
            Slot slotCreated = listOfSlots.get(i);
            if (
                slotCreated.vaccineOfSlot.vaccineName.equals(vaccineToBeAdded.vaccineName) 
                && slotCreated.dayNum == dayNum
            ) {
                slotCreated.vaccineQuantity += quantity;
                notPresent = false;
                return i;
            }
        }
        int x = 0;
        if (notPresent) {
            Slot slotCreated = new Slot(vaccineToBeAdded, dayNum, quantity);
            x = listOfSlots.size();
            listOfSlots.add(slotCreated);        
        }
        return x;
    }
}

class AllHospitals {

    ArrayList<Hospital> hospitalList = new ArrayList<Hospital>();

    void registration(String hospitalName, int pincode) {
        Hospital toBeAdded = new Hospital(hospitalName, pincode);
        hospitalList.add(toBeAdded);
        System.out.println("Hospital Name: "+hospitalName+", PinCode: "+pincode+", UniqueID: "+toBeAdded.uniquehID);
    }

    void slotAdditionWithID(Vaccine vaccineToBeAdded, String inputID, int dayNum, int quantity) {
        Hospital temp = new Hospital("a", 0);
        int y = 0;
        for (int i = 0; i < hospitalList.size(); i++) {
            String x = hospitalList.get(i).uniquehID;
            if (x.equals(inputID)) {
                temp = hospitalList.get(i);
                y = temp.slotCreation(vaccineToBeAdded, dayNum, quantity);
                hospitalList.set(i, temp);
                break;
            }
        }
        System.out.println("Slot added by Hospital "+inputID+" for Day: "+dayNum+", Available Quantity: "+temp.listOfSlots.get(y).vaccineQuantity+" of Vaccine "+vaccineToBeAdded.vaccineName);
    }

    void listHospitalsWithPinCode(int pincode) {
        for (int i = 0; i < hospitalList.size(); i++) {
            if (hospitalList.get(i).pincode == pincode) {
                System.out.println(hospitalList.get(i).uniquehID+" "+hospitalList.get(i).hospitalName);
            }
        }
    }

    Vaccine[] listSlotsfor5(String hospitalID) {
        Vaccine[] vaccinesReturned = new Vaccine[0];
        for (int i = 0; i < hospitalList.size(); i++) {
            if (hospitalList.get(i).uniquehID.equals(hospitalID)) {
                ArrayList<Slot> temp = hospitalList.get(i).listOfSlots;
                if (temp.size() == 0) {
                    System.out.println("No slots available");
                    break;
                }
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

    void listSlotsOnly(String hospitalID) {
        for (int i = 0; i < hospitalList.size(); i++) {
            if (hospitalList.get(i).uniquehID.equals(hospitalID)) {
                ArrayList<Slot> temp = hospitalList.get(i).listOfSlots;
                if (temp.size() == 0) {
                    System.out.println("No slots available");
                    break;
                }
                for (int j = 0; j < temp.size(); j++) {
                    System.out.println("Day: "+temp.get(j).dayNum+", Vaccine: "+temp.get(j).vaccineOfSlot.vaccineName+", Available Qty: "+temp.get(j).vaccineQuantity);
                }
                break;
            }
        }
    }
    
    void listHospitalViaVaccineName(String nameOfVac) {
        for (int i = 0; i < hospitalList.size(); i++) {
            for (int j = 0; j < hospitalList.get(i).listOfSlots.size(); j++) {
                if(hospitalList.get(i).listOfSlots.get(j).vaccineOfSlot.vaccineName.equals(nameOfVac)) {
                    System.out.println(hospitalList.get(i).uniquehID+" "+hospitalList.get(i).hospitalName);
                }
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
                String hospitalID = in.nextLine();
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
                    System.out.print("Enter Hospital ID: ");
                    String hospitalID = in.nextLine();
                    Vaccine[] returned = hospitalList.listSlotsfor5(hospitalID);
                    if(returned.length != 0) {
                        System.out.print("Choose Slot: ");
                        int slotNo = Integer.parseInt(in.nextLine());
                        int i = 0;
                        while(i < hospitalList.hospitalList.size()) {
                            if (hospitalList.hospitalList.get(i).uniquehID.equals(hospitalID)) {
                                break;
                            }
                            i++;
                        }
                        Hospital temp = hospitalList.hospitalList.get(i);
                        Slot temp1 = temp.listOfSlots.get(slotNo);
                        int daynum = temp1.dayNum;
                        int ind = citizenList.bookSlot(uniqueID, returned[slotNo], daynum);
                        if (ind != -1) {
                            temp1.vaccineQuantity--;
                            temp.listOfSlots.set(slotNo, temp1);
                            hospitalList.hospitalList.set(i, temp);                    
                            System.out.println(citizenList.citizenList.get(ind).citizenName+" vaccinated with "+citizenList.citizenList.get(ind).givenVac.vaccineName);
                        } else {
                            System.out.println("Invalid Slot");
                        }
                    } else {
                        System.out.println("No slots available");
                    }
                    
                } else if (option == 2) {

                    System.out.print("Enter Vaccine Name: ");
                    String vaccineName = in.nextLine();
                    hospitalList.listHospitalViaVaccineName(vaccineName);
                    System.out.print("Enter Hospital ID: ");
                    String hospitalID = in.nextLine();
                    Vaccine[] returned = hospitalList.listSlotsfor5(hospitalID);
                    if(returned.length != 0) {
                        System.out.print("Choose Slot: ");
                        int slotNo = Integer.parseInt(in.nextLine());
                        int i = 0;
                        while(i < hospitalList.hospitalList.size()) {
                            if (hospitalList.hospitalList.get(i).uniquehID.equals(hospitalID)) {
                                break;
                            }
                            i++;
                        }
                        Hospital temp = hospitalList.hospitalList.get(i);
                        Slot temp1 = temp.listOfSlots.get(slotNo);
                        int daynum = temp1.dayNum;
                        int ind = citizenList.bookSlot(uniqueID, returned[slotNo], daynum);
                        if (ind != -1) {
                            temp1.vaccineQuantity--;
                            temp.listOfSlots.set(slotNo, temp1);
                            hospitalList.hospitalList.set(i, temp);                    
                            System.out.println(citizenList.citizenList.get(ind).citizenName+" vaccinated with "+citizenList.citizenList.get(ind).givenVac.vaccineName);
                        } else {
                            System.out.println("Invalid Slot");
                        }
                    } else {
                        System.out.println("No slots available");
                    }

                } else if (option == 3) {

                } else {
                    System.out.println("Wrong Option, exiting");
                }

            } else if (queryNo == 6) {

                System.out.print("Enter Hospital ID: ");
                String hospitalID = in.nextLine();
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
                    if (citizenList.citizenList.get(i).uniqueID.equals(uniqueID)) {
                        temp = citizenList.citizenList.get(i);
                        vacName = temp.givenVac.vaccineName;
                        status = temp.vaccinationStatus;
                        dosesNo = temp.noOfDosesGiven;
                        duedate = temp.nextDueDate;
                        break;
                    }
                }
                if (status.equals("REGISTERED")) {
                    System.out.println(status);
                } else {
                    System.out.println(status);
                    System.out.println("Vaccine Given: "+vacName);
                    System.out.println("Number of Doses given: "+dosesNo);
                    if (!status.equals("FULLY VACCINATED")) {
                        System.out.println("Next Dose due date: "+duedate);
                    }
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