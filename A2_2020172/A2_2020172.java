import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;


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
		Date date = new Date();

		ArrayList<String> commentsList = new ArrayList<String>();
		ArrayList<User> usersList = new ArrayList<User>();
		ArrayList<Assessments> assessmentsList = new ArrayList<Assessments>();
		ArrayList<Lectures> lectureList = new ArrayList<Lectures>(); 

		int mainMenuSelection = Integer.parseInt(in.nextLine());
		while (mainMenuSelection != 3) {
			
			if (mainMenuSelection == 1) {

				System.out.println("Instructors:");
				for (User user : usersList) {
					if (user instanceof Instructor){
						//print inst details
					}
				}

				System.out.print("Choose id: ");
				int instID = Integer.parseInt(in.nextLine());

				System.out.println("Welcome I"+instID);

				instructorMenu();
				int instMenuSelection = Integer.parseInt(in.nextLine());
				
				while (instMenuSelection != 9) {
					
					if (instMenuSelection == 1) {
						
						System.out.println("1. Add Lecture Slide");
						System.out.println("1. Add Lecture Video");
						int lectureMenuOption = Integer.parseInt(in.nextLine());
						
						if (lectureMenuOption == 1) {
							System.out.print("Enter topic of slides: ");
							String slideName = in.nextLine();
							System.out.print("Enter number of slides: ");
							int noOfSlides = Integer.parseInt(in.nextLine());
							ArrayList<String> listOfSlideContent = new ArrayList<>();
							for (int i = 0; i < noOfSlides; i++) {
								System.out.println("Content of slide "+i);
								String content = in.nextLine();
								listOfSlideContent.add(content);
							}
							lectureList.add(new LectureSlide(slideName, listOfSlideContent, date.toString(), instID));
						} else if (lectureMenuOption == 2) {
							System.out.print("Enter topic of video: ");
							String topic = in.nextLine();
							System.out.print("Enter filename of video: ");
							String fileName = in.nextLine();
							if (fileName.substring(fileName.length()-4).equals(".mp4")) {
								lectureList.add(new LectureVideo(topic, fileName, date.toString(), instID));
							} else {
								System.out.println("Wrong Syntax!");
							}
						}
	
					} else if (instMenuSelection == 2) {
						System.out.println("1. Add Assignment");
						System.out.println("1. Add Quiz");
						int assessMenuOption = Integer.parseInt(in.nextLine());
						
						if (assessMenuOption == 1) {
							System.out.print("Enter problem statement: ");
							String problemStatement = in.nextLine();
							System.out.print("Enter max marks: ");
							int maxMarks = Integer.parseInt(in.nextLine());
							int indexOfAssessment = assessmentsList.size();
							assessmentsList.add(new Assignment(problemStatement, maxMarks, indexOfAssessment));
						} else if (assessMenuOption == 2) {
							System.out.print("Enter quiz question: ");
							String quizQuestion = in.nextLine();
							int indexOfAssessment = assessmentsList.size();
							assessmentsList.add(new Quiz(quizQuestion, indexOfAssessment));
						}
	
					} else if (instMenuSelection == 3) {
						for (Lectures i : lectureList) {
							i.viewLectureMaterial();
						}
	
					} else if (instMenuSelection == 4) {
						for (Assessments i : assessmentsList) {
							i.viewAssesmentMaterial();
						}
	
					} else if (instMenuSelection == 5) {
						System.out.println("List of assessments");
						for (Assessments i : assessmentsList) {
							i.viewAssesmentMaterial();
						}
						
						System.out.print("Enter ID of assessment to view submissions: ");
						int assessmentID = Integer.parseInt(in.nextLine());
						System.out.println("Choose ID from these ungraded submissions");
						//list ids of students with that assessment as ungraded
						int ungradedstudentID = Integer.parseInt(in.nextLine());
						

						System.out.println("Max Marks: ");
						System.out.print("Marks scored: ");
						int marksScored = Integer.parseInt(in.nextLine());
	
					} else if (instMenuSelection == 6) {
						System.out.println("List of open assessments");
						for (int i = 0; i < assessmentsList.size(); i++) {
							if(!assessmentsList.get(i).gradedStatusCheck()) {
								assessmentsList.get(i).viewAssesmentMaterial();
							}
						}
						System.out.print("Enter id of assignment to close: ");
						int assessmentIDtoclose = Integer.parseInt(in.nextLine());
						for (Assessments assessment : assessmentsList) {
							if (assessment.getIndexOfAssessment() == assessmentIDtoclose) {
								assessment.closeTask();
							}
						}
	
					} else if (instMenuSelection == 7) {
						for (int i = 0; i < commentsList.size(); i++) {
							System.out.println(commentsList.get(i));
						}
	
	
					} else if (instMenuSelection == 8) {
						System.out.print("Enter comment: ");
						String commentToBeAdded = in.nextLine();
						commentsList.add(commentToBeAdded+" - I"+instID);
						commentsList.add(date.toString());
						commentsList.add("");
					}
					System.out.println("Welcome I"+instID);
					instructorMenu();
					instMenuSelection = Integer.parseInt(in.nextLine());
				}

			} else if (mainMenuSelection == 2) {
				
				System.out.println("Students:");
				for (User user : usersList) {
					if (user instanceof Student){
						//print student details
					}
				}
				System.out.print("Choose id: ");
				int stuID = Integer.parseInt(in.nextLine());

				System.out.println("Welcome S"+stuID);
				studentMenu();
				int stuMenuSelection = Integer.parseInt(in.nextLine());
				
				while(stuMenuSelection != 7) {

					if (stuMenuSelection == 1) {
						for (Lectures i : lectureList) {
							i.viewLectureMaterial();
						}

					} else if (stuMenuSelection == 2) {
						for (Assessments i : assessmentsList) {
							i.viewAssesmentMaterial();
						}

					} else if (stuMenuSelection == 3) {
						//print pending assessments
						System.out.print("Enter ID of assessment: ");
						int asssessID = Integer.parseInt(in.nextLine());
						System.out.print("Enter filename of assignment: ");
						String assessfileName = in.nextLine();
						if (assessfileName.substring(assessfileName.length()-4).equals(".zip")) {
							//add assignment
							
						} else {
							System.out.println("Wrong Syntax!");
						}

					} else if (stuMenuSelection == 4) {
						System.out.println("Graded Submissions");
						//print graded subm

						System.out.println("-------------------------");
						System.out.println("Graded Submissions");
						//print ungraded subm

					} else if (stuMenuSelection == 5) {
						for (int i = 0; i < commentsList.size(); i++) {
							System.out.println(commentsList.get(i));
						}

					} else if (stuMenuSelection == 6) {
						System.out.print("Enter comment: ");
						String commentToBeAdded = in.nextLine();
						commentsList.add(commentToBeAdded+" - S"+stuID);
						commentsList.add(date.toString());
						commentsList.add("");				

					}
					System.out.println("Welcome S"+stuID);
					studentMenu();
					stuMenuSelection = Integer.parseInt(in.nextLine());
				}
			} else {
				System.out.println("Wrong option");
			}
			mainMenu();
			mainMenuSelection = Integer.parseInt(in.nextLine());
		}
		System.out.println("------------------------------------------");
		in.close();
	}
}