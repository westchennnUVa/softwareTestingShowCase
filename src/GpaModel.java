import junit.framework.Assert;
import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GpaModel implements FsmModel {
    private GpaAdapter adapter = new GpaAdapter();
    private GradeBoxState gradeBoxState = GradeBoxState.Empty;
    private State state = State.EmptyGradeBoxEmptySummary;

    private List<String> courseNames  = new ArrayList<String>();
    private List<Integer> courseHours  = new ArrayList<Integer>();
    private List<String>  courseGrades = new ArrayList<String>();

    private String[] courseNamesExample = {"one", "two", "three"};
    private String[] courseHoursExample = {"1","2","3"};
    private String[] courseGradesExample = {"A+", "A", "A-", "B+", "B", "B-", "C", "D", "F"};

    private enum GradeBoxState {Empty, NotEmpty}

    // Maybe change NotEmpty to OneGradeBox, TwoGradeBoxes, MoreThanTwoGradeBoxes, then use the gpa method to check its gpa
    private enum State {EmptyGradeBoxEmptySummary, NotEmptyGradeBoxEmptySummary,
        NotEmptyGradeBoxLatestSummary, NotEmptyGradeBoxOldSummary, InvalidState}

    public Object getState() {return state;}

    public void reset(boolean b) {
        courseNames = new ArrayList<>();
        courseHours = new ArrayList<>();
        courseGrades = new ArrayList<>();
        adapter.gpaReset();

        gradeBoxState = GradeBoxState.Empty;
        state = State.EmptyGradeBoxEmptySummary;
    }

    public Float getGpa ()
    {
        Float qualityPoints = 0f;
        Float gradeValue;
        int totalHours = 0;
        int hours;
        Iterator<Integer> itrHours = courseHours.iterator();
        Iterator<String> itrGrade = courseGrades.iterator();

        while (itrHours.hasNext() & itrGrade.hasNext())
        {
            hours = itrHours.next();
            gradeValue = getGradeValue (itrGrade.next()) * hours;
            if (gradeValue > 0)
                qualityPoints = qualityPoints + gradeValue;
            else // An F grade (or something else) doesn't count)
            {
                hours = 0;
            }
            totalHours = totalHours + hours;
        }
        if (totalHours >0)
            return (qualityPoints / (new Float (totalHours)));
        else
            return (0f);
    }

    public Float getGradeValue (String courseGrade)
    {
        Float grade = 0f;

        if (courseGrade.equals ("A+") || courseGrade.equals ("A"))
        {
            grade = 4f;
        } else if (courseGrade.equals ("A-"))
        {
            grade = 3.67f;
        } else if (courseGrade.equals ("B+"))
        {
            grade = 3.33f;
        } else if (courseGrade.equals ("B"))
        {
            grade = 3f;
        } else if (courseGrade.equals ("B-"))
        {
            grade = 2.67f;
        } else if (courseGrade.equals ("C"))
        {
            grade = 2f;
        }
        else // anything else is equivalent to F
            grade = 0f;
        return (grade);
    }

    @Action
    public void addCourse() {
        Random random = new Random();
        String singleCourseName = courseNamesExample[random.nextInt(courseNamesExample.length)];
        String singleCourseCredit = courseHoursExample[random.nextInt(courseHoursExample.length)];
        String singleCourseGrade = courseGradesExample[random.nextInt(courseGradesExample.length)];

        adapter.setCourse(singleCourseName, singleCourseCredit, singleCourseGrade);
        courseNames.add(singleCourseName);
        courseHours.add(Integer.valueOf(singleCourseCredit));
        courseGrades.add(singleCourseGrade);

        if (gradeBoxState == GradeBoxState.Empty) {
            gradeBoxState = GradeBoxState.NotEmpty;
        }
        if (state == State.EmptyGradeBoxEmptySummary)
            state = State.NotEmptyGradeBoxEmptySummary;
        else if(state == State.NotEmptyGradeBoxLatestSummary)
            state = State.NotEmptyGradeBoxOldSummary;
        Assert.assertEquals("courseName correct", singleCourseName, adapter.getCourseName());
        Assert.assertEquals("courseHours correct", Integer.valueOf(singleCourseCredit).intValue(), adapter.getCourseNumber());
        Assert.assertEquals("courseGrade correct", singleCourseGrade, adapter.getCourseGrade());
        adapter.setNextCourse();
    }

    @Action
    public void calculateGPA() {
        if(gradeBoxState != GradeBoxState.Empty){
            Assert.assertEquals("GPA correct",getGpa(),adapter.getGpa());
            if(state == State.NotEmptyGradeBoxOldSummary || state == State.NotEmptyGradeBoxEmptySummary)
                state = State.NotEmptyGradeBoxLatestSummary;
        }else
            state = State.InvalidState;
    }
}
