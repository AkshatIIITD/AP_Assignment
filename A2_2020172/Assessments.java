public interface Assessments {
    
    void gradeTask(int marksScored);
    void closeTask();
    void viewAssesmentMaterial();
    boolean gradedStatusCheck();
    boolean assignmentStatusCheck();
    int getIndexOfAssessment();
    int getMaxMarks();
    String getAssessmentSol();
    void setAssessmentSol(String submission);
    String getAssessmentName();
}


class Assignment implements Assessments{

    String assignmentName;
    String fileName;
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

    @Override
    public int getMaxMarks() {
        return maxMarks;
    }

    @Override
    public String getAssessmentSol() {
        return fileName;
    }

    @Override
    public boolean assignmentStatusCheck() {
        return assignmentStatus;
    }

    @Override
    public void setAssessmentSol(String submission) {
        fileName = submission;
    }

    @Override
    public String getAssessmentName() {
        return assignmentName;
    }

}

class Quiz implements Assessments{

    int indexOfAssessment;
    String quizQuestion;
    String answer;
    int marksScored;
    boolean gradedStatus;
    boolean quizStatus;
    boolean assignmentStatus;

    Quiz(String quizQuestion, int indexOfAssessment) {
        this.quizQuestion = quizQuestion;
        this.gradedStatus = false;
        this.indexOfAssessment = indexOfAssessment;
        this.assignmentStatus = true;
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
        System.out.println("ID: "+indexOfAssessment+" Question: "+quizQuestion);
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

    @Override
    public int getMaxMarks() {
        return 1;
    }

    @Override
    public String getAssessmentSol() {
        return answer;
    }

    @Override
    public boolean assignmentStatusCheck() {
        return assignmentStatus;
    }

    @Override
    public void setAssessmentSol(String submission) {
        answer = submission;
    }

    @Override
    public String getAssessmentName() {
        return quizQuestion;
    }

}