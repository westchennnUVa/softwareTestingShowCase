import computeGPA.gpa;

public class GpaAdapter {
    private gpa gpaObject = new gpa();

    public void gpaReset(){
        gpaObject.gpaReset();
    }

    public void setCourse(String courseName, String courseCredit, String courseGrade) {
        gpaObject.setCourse(courseName, courseCredit, courseGrade);
    }

    public String getCourseName() {
        return gpaObject.getCourseName();
    }

    public int getCourseNumber() {
        return gpaObject.getCourseHours();
    }

    public String getCourseGrade() {
        return gpaObject.getCourseGrade();
    }

    public void setNextCourse() {
        gpaObject.setNextCourse();
    }

    public float getGpa() {
        return gpaObject.getGpa();
    }

    public void getSummaryMessage() {
        gpaObject.getSummaryMessage();
    }

}
