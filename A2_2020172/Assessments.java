public interface Assessments {
    void setAssessmentSol(String submission);
    void gradeTask(int marksScored, int graderID);
    void closeTask();
    void viewAssesmentMaterial();
    boolean gradedStatusCheck();
    boolean assessmentStatusCheck();
    boolean submittedStatusCheck();
    int getIndexOfAssessment();
    int getMaxMarks();
    String getAssessmentSol();
    String getAssessmentName();
    int getScoredMarks();
    int getGradedBy();
}


class Assignment implements Assessments{

    String assignmentName;
    String fileName;
    int graderID;
    int maxMarks;
    int marksScored;
    int indexOfAssessment;
    boolean gradedStatus;
    boolean assessmentStatus;
    boolean submittedStatus;

    Assignment(String assignmentName, int maxMarks, int indexOfAssessment) {
        this.assignmentName = assignmentName;
        this.maxMarks = maxMarks;
        this.indexOfAssessment = indexOfAssessment;
        this.gradedStatus = false;
        this.assessmentStatus = true;
        this.submittedStatus = false;
    }

    @Override
    public void gradeTask(int marksScored, int graderID) {
        this.marksScored = marksScored;
        gradedStatus = true;
        this.graderID = graderID;
    }

    @Override
    public void closeTask() {
        assessmentStatus = false;
    }

    @Override
    public void viewAssesmentMaterial() {
        System.out.println("ID: "+indexOfAssessment+" Assignment: "+assignmentName+ " Max Marks: "+maxMarks);
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
    public boolean assessmentStatusCheck() {
        return assessmentStatus;
    }

    @Override
    public void setAssessmentSol(String submission) {
        fileName = submission;
        submittedStatus = true;
    }

    @Override
    public String getAssessmentName() {
        return assignmentName;
    }

    @Override
    public boolean submittedStatusCheck() {
        return submittedStatus;
    }

    @Override
    public int getScoredMarks() {
        return marksScored;
    }

    @Override
    public int getGradedBy() {
        return graderID;
    }
}

class Quiz implements Assessments{

    int indexOfAssessment;
    String quizQuestion;
    String answer;
    int graderID;
    int marksScored;
    boolean gradedStatus;
    boolean assessmentStatus;
    boolean submittedStatus;

    Quiz(String quizQuestion, int indexOfAssessment) {
        this.quizQuestion = quizQuestion;
        this.indexOfAssessment = indexOfAssessment;
        this.gradedStatus = false;
        this.assessmentStatus = true;
        this.submittedStatus = false;
    }

    @Override
    public void gradeTask(int marksScored, int graderID) {
        gradedStatus = true;
        this.marksScored = marksScored;
        this.graderID = graderID;
    }

    @Override
    public void closeTask() {
        assessmentStatus = false;
    }

    @Override
    public void viewAssesmentMaterial() {
        System.out.println("ID: "+indexOfAssessment+" Question: "+quizQuestion);
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
    public boolean assessmentStatusCheck() {
        return assessmentStatus;
    }

    @Override
    public void setAssessmentSol(String submission) {
        answer = submission;
        submittedStatus = true;
    }

    @Override
    public String getAssessmentName() {
        return quizQuestion;
    }

    @Override
    public boolean submittedStatusCheck() {
        return submittedStatus;
    }

    @Override
    public int getScoredMarks() {
        return marksScored;
    }

    @Override
    public int getGradedBy() {
        return graderID;
    }
}