import java.util.ArrayList;

public interface User {
    void submitAssessment(int assessmentID, String submission);
    void addAssessmentForStudent(Assessments assessmentToBeAdded);
    void gradeAssessment(int assessmentID, int marksScored);
}

class Instructor implements User {
    
    int instID;
    
    Instructor(int instID) {
        this.instID = instID;
    }

    @Override
    public void gradeAssessment(int assessmentID, int marksScored) {
    }

    @Override
    public void addAssessmentForStudent(Assessments assessmentToBeAdded) {        
    }

    @Override
    public void submitAssessment(int assessmentID, String submission) {   
    }
}

class Student implements User {
    
    int stuID;
    ArrayList<Assessments> assessmentsOfThisStudent;
    
    Student(int stuID, ArrayList<Assessments> assessmentsOfThisStudent) {
        this.stuID = stuID;
        this.assessmentsOfThisStudent = assessmentsOfThisStudent;
    }

    @Override
    public void gradeAssessment(int assessmentID, int marksScored) {
        assessmentsOfThisStudent.get(assessmentID).gradeTask(marksScored);
    }

    @Override
    public void addAssessmentForStudent(Assessments assessmentToBeAdded) {
        assessmentsOfThisStudent.add(assessmentToBeAdded);
    }

    @Override
    public void submitAssessment(int assessmentID, String submission) {
        assessmentsOfThisStudent.get(assessmentID).setAssessmentSol(submission);
    }
}