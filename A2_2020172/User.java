import java.util.ArrayList;

public interface User {
    void submitAssessment(int assessmentID, String submission);
    void addAssessmentForStudent(Assessments assessmentToBeAdded);
    void gradeAssessment(int assessmentID, int marksScored, int graderID);
    boolean printPendingAssessments();
    void printGradedAssignments();
    void printUngradedAssignments();
    ArrayList<Assessments> returnListOfAssessments();
}

class Instructor implements User {
    
    int instID;
    
    Instructor(int instID) {
        this.instID = instID;
    }

    @Override
    public void gradeAssessment(int assessmentID, int marksScored, int graderID) {
    }

    @Override
    public void addAssessmentForStudent(Assessments assessmentToBeAdded) {        
    }

    @Override
    public void submitAssessment(int assessmentID, String submission) {   
    }

    @Override
    public boolean printPendingAssessments() {
        return true;
    }

    @Override
    public void printGradedAssignments() {
    }

    @Override
    public void printUngradedAssignments() {       
    }

    @Override
    public ArrayList<Assessments> returnListOfAssessments() {
        return new ArrayList<>();
    }
}

class Student implements User {
    
    int stuID;
    ArrayList<Assessments> assessmentsOfThisStudent;
    
    Student(int stuID, ArrayList<Assessments> assessmentsOfThisStudent) {
        this.stuID = stuID;
        this.assessmentsOfThisStudent = new ArrayList<Assessments>();
    }

    @Override
    public void gradeAssessment(int assessmentID, int marksScored, int graderID) {
        Assessments temp = assessmentsOfThisStudent.get(assessmentID);
        temp.gradeTask(marksScored, graderID);
        assessmentsOfThisStudent.set(assessmentID, temp);
    }

    @Override
    public void addAssessmentForStudent(Assessments assessmentToBeAdded) {
        assessmentsOfThisStudent.add(assessmentToBeAdded);
    }

    @Override
    public void submitAssessment(int assessmentID, String submission) {
        Assessments temp = assessmentsOfThisStudent.get(assessmentID);
        temp.setAssessmentSol(submission);
        assessmentsOfThisStudent.set(assessmentID, temp);
    }

    @Override
    public boolean printPendingAssessments() {
        boolean x = false;
        for (int i = 0; i < assessmentsOfThisStudent.size(); i++) {
            if (!assessmentsOfThisStudent.get(i).submittedStatusCheck()) {
                assessmentsOfThisStudent.get(i).viewAssesmentMaterial();
                x = true;
            }                         
        }
        return x;
    }

    @Override
    public void printGradedAssignments() {
        for (int i = 0; i < assessmentsOfThisStudent.size(); i++) {
            if (assessmentsOfThisStudent.get(i).gradedStatusCheck()) {
                System.out.println("Submission: "+assessmentsOfThisStudent.get(i).getAssessmentSol());
                System.out.println("Marks scored: "+assessmentsOfThisStudent.get(i).getScoredMarks());
                System.out.println("Graded by: I"+assessmentsOfThisStudent.get(i).getGradedBy());
            }
        }        
    }

    @Override
    public void printUngradedAssignments() {
        for (int i = 0; i < assessmentsOfThisStudent.size(); i++) {
            if (!assessmentsOfThisStudent.get(i).gradedStatusCheck()) {
                System.out.println("Submission: "+assessmentsOfThisStudent.get(i).getAssessmentSol());
            }
        }
    }

    @Override
    public ArrayList<Assessments> returnListOfAssessments() {
        return assessmentsOfThisStudent;
    }
}