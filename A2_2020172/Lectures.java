import java.util.ArrayList;
import java.util.Date;

public interface Lectures {
    void viewLectureMaterial();
}

class LectureSlide implements Lectures {

    String slideName;
    ArrayList<String> listOfSlideContent;
    String dateOfUpload;
    int uploaderID;

    LectureSlide(String slideName, ArrayList<String> listOfSlideContent, int uploaderID) {
        Date datenew = new Date();
        this.listOfSlideContent = listOfSlideContent;
        this.slideName = slideName;
        this.dateOfUpload = datenew.toString();
        this.uploaderID = uploaderID;
    }

    @Override
    public void viewLectureMaterial() {
        System.out.println("Title: " +slideName);
        for (int i = 0; i < listOfSlideContent.size(); i++) {
            System.out.println("Slide "+(i+1)+": "+listOfSlideContent.get(i));
        }
        System.out.println("Number of slides: "+listOfSlideContent.size());
        System.out.println("Date of upload: "+dateOfUpload);
        System.out.println("Uploaded by: I"+uploaderID);
    }

}

class LectureVideo implements Lectures {
    
    String videoTopic;
    String videoFile;
    String dateOfUpload;
    int uploaderID;

    LectureVideo(String videoTopic, String videoFile, int uploaderID) {
        Date datenew = new Date();
        this.videoTopic = videoTopic;
        this.videoFile = videoFile;
        this.dateOfUpload = datenew.toString();
        this.uploaderID = uploaderID;
    }

    @Override
    public void viewLectureMaterial() {
        System.out.println("Title of video: " + videoTopic);
        System.out.println("Video file: "+ videoFile);
        System.out.println("Date of upload: "+dateOfUpload);
        System.out.println("Uploaded by: I"+uploaderID);
    }
}