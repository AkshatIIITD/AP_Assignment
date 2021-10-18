import java.util.Scanner;

public class A2_2020172{
	public static void mainMenu() {
		System.out.println("");
		System.out.println("Welcome to BackPack");
		System.out.println("1. Enter as instructor");
		System.out.println("2. Enter as student");
		System.out.println("3. Exit");
		System.out.println("");
	}

	public static void instructorMenu() {
		System.out.println("");
		System.out.println("INSTRUCTOR MENU");
		System.out.println("1. Add class material");
		System.out.println("2. Add assessments");
		System.out.println("3. View lecture materials");
		System.out.println("4. View assessments");
		System.out.println("5. Grade assessments");
		System.out.println("6. Close assessment");
		System.out.println("7. View comments");
		System.out.println("8. Add comments");
		System.out.println("9. Logout");
		System.out.println("");
	}

	public static void studentMenu() {
		System.out.println("");
		System.out.println("STUDENT MENU");
		System.out.println("1. View lecture materials");
		System.out.println("2. View assessments");
		System.out.println("3. Submit assessment");
		System.out.println("4. View grades");
		System.out.println("5. View comments");
		System.out.println("6. Add comments");
		System.out.println("7. Logout");
		System.out.println("");
	}
	
	public static void main(String[] args) {
		mainMenu();
	
		
		Scanner in = new Scanner(System.in);
		int mainMenuSelection = Integer.parseInt(in.nextLine());
		while (mainMenuSelection != 3) {
			
			if (mainMenuSelection == 1) {

				System.out.println("Instructors:");


				System.out.print("Choose id: ");
				int instID = Integer.parseInt(in.nextLine());

				System.out.println("Welcome ");//add id
				instructorMenu();


			} else if (mainMenuSelection == 2) {
				
				System.out.println("Students:");


				System.out.print("Choose id: ");
				int stuID = Integer.parseInt(in.nextLine());

				System.out.println("Welcome ");//add id
				studentMenu();


			} else {
				System.out.println("Wrong option");
			}

			mainMenu();
			mainMenuSelection = Integer.parseInt(in.nextLine());
		}
		in.close();
	}
}	
