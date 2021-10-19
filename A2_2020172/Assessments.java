public interface Assessments {
    void gradeTask(int marksScored);
    void closeTask();
    String returnName();
}


class Assignments implements Assessments{

    String assignmentName;
    int maxMarks;
    int marksScored;
    boolean gradedStatus;
    boolean assignmentStatus;

    Assignments(String assignmentName, int maxMarks) {
        this.assignmentName = assignmentName;
        this.maxMarks = maxMarks;
        this.gradedStatus = false;
        this.assignmentStatus = true;
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
    public String returnName() {
        return assignmentName;
    }

}

class Quiz implements Assessments{

    String quizName;
    int marksScored;
    boolean gradedStatus;
    boolean quizStatus;

    Quiz(String quizName) {
        this.quizName = quizName;
        this.gradedStatus = false;
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
    public String returnName() {
        return quizName;
    }

}