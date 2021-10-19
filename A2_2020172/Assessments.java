public interface Assessments {
    
    void gradeTask(int marksScored);
    void closeTask();
    void viewAssesmentMaterial();
    boolean gradedStatusCheck();
    int getIndexOfAssessment();
}


class Assignment implements Assessments{

    String assignmentName;
    int maxMarks;
    int marksScored;
    int indexOfAssessment;
    boolean gradedStatus;
    boolean assignmentStatus;

    Assignment(String assignmentName, int maxMarks, int indexOfAssessment) {
        this.assignmentName = assignmentName;
        this.maxMarks = maxMarks;
        this.gradedStatus = false;
        this.assignmentStatus = true;
        this.indexOfAssessment = indexOfAssessment;
    }

    @Override
    public void gradeTask(int marksScored) {
        this.marksScored = marksScored;
        gradedStatus = true;
        
    }

    @Override
    public void closeTask() {
        assignmentStatus = false;
        
    }

    @Override
    public void viewAssesmentMaterial() {
        System.out.println("ID: "+indexOfAssessment+" Assignment: "+assignmentName+ " Max Marks: "+maxMarks);
        System.out.println("----------------");
    }

    @Override
    public boolean gradedStatusCheck() {
        return gradedStatus;
    }

    @Override
    public int getIndexOfAssessment() {
        return indexOfAssessment;
    }

}

class Quiz implements Assessments{

    int indexOfAssessment;
    String quizName;
    int marksScored;
    boolean gradedStatus;
    boolean quizStatus;

    Quiz(String quizName, int indexOfAssessment) {
        this.quizName = quizName;
        this.gradedStatus = false;
        this.indexOfAssessment = indexOfAssessment;
    }

    @Override
    public void gradeTask(int marksScored) {
        gradedStatus = true;
        this.marksScored = marksScored;
        
    }

    @Override
    public void closeTask() {
        quizStatus = false;
    }

    @Override
    public void viewAssesmentMaterial() {
        System.out.println("ID: "+indexOfAssessment+" Question: "+quizName);
        System.out.println("----------------");
    }

    @Override
    public boolean gradedStatusCheck() {
        return gradedStatus;
    }

    @Override
    public int getIndexOfAssessment() {
        return indexOfAssessment;
    }

}