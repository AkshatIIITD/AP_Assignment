import java.util.ArrayList;

public interface Lectures {
    void viewLectureMaterial();
}

class LectureSlide implements Lectures {

    String slideName;
    ArrayList<String> listOfSlideContent;
    String dateOfUpload;
    int uploaderID;

    LectureSlide(String slideName, ArrayList<String> listOfSlideContent, String dateOfUpload, int uploaderID) {
        this.listOfSlideContent = listOfSlideContent;
        this.slideName = slideName;
        this.dateOfUpload = dateOfUpload;
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

    LectureVideo(String videoTopic, String videoFile, String dateOfUpload, int uploaderID) {
        this.videoTopic = videoTopic;
        this.videoFile = videoFile;
        this.dateOfUpload = dateOfUpload;
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