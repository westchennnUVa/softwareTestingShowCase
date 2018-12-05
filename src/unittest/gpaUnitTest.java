package unittest;

/**
 * Created by Westchennn on 9/13/18.
 */

import computeGPA.gpa;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 1. test1 passes
 * 2. test2 passes
 * 3. test2 includes not only one method, which is not good at all
 * 4. Split remove function and add different value function into two test case.
 */


public class gpaUnitTest
{
    gpa gpaObject;

    @Before
    public void setUp()
    {
        gpaObject = new gpa();
    }

    @Test
    public void test_getGradeValue_129_1()
    {
        float gradeValue = gpaObject.getGradeValue("A+");
        assertEquals("getGradeValue_testcase_129_wrong", 4.0f, gradeValue, 0.0);
    }

    @Test
    public void test_getGradeValue_129_2()
    {
        float gradeValue = gpaObject.getGradeValue("A");
        assertEquals("getGradeValue_testcase_129_wrong", 4.0f, gradeValue, 0.0);
    }

    @Test
    public void test_getGradeValue_139()
    {
        float gradeValue = gpaObject.getGradeValue("A-");
        assertEquals("getGradeValue_testcase_139_wrong", 3.67f, gradeValue, 0.0);
    }

    @Test
    public void test_getGradeValue_149()
    {
        float gradeValue = gpaObject.getGradeValue("B+");
        assertEquals("getGradeValue_testcase_149_wrong", 3.33f, gradeValue, 0.0);
    }

    @Test
    public void test_getGradeValue_159()
    {
        float gradeValue = gpaObject.getGradeValue("B");
        assertEquals("getGradeValue_testcase_159_wrong", 3.0f, gradeValue, 0.0);
    }

    @Test
    public void test_getGradeValue_169()
    {
        float gradeValue = gpaObject.getGradeValue("B-");
        assertEquals("getGradeValue_testcase_169_wrong", 2.67f, gradeValue, 0.0);
    }

    @Test
    public void test_getGradeValue_179()
    {
        float gradeValue = gpaObject.getGradeValue("C");
        assertEquals("getGradeValue_testcase_179_wrong", 2.0f, gradeValue, 0.0);
    }

    @Test
    public void test_getGradeValue_189()
    {
        float gradeValue = gpaObject.getGradeValue("F");
        assertEquals("getGradeValue_testcase_189_wrong", 0.0f, gradeValue, 0.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_getCourseName_13()
    {
        gpaObject.getCourseName();
    }

    // This part is a little bit tricky, cause this function depend on another function
    // Cause if I want to test the functionality of getCourseName, I have to assume setCourse is valid firstly
    // I will test setCourse later
    @Test
    public void test_getCourseName_12()
    {
        gpaObject.setCourse("courseOne", "3", "A");
        assertEquals("getCourseName_testcase_12_wrong","courseOne",  gpaObject.getCourseName());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_getCourseHours_13()
    {
        gpaObject.getCourseName();
    }

    // This part is a little bit tricky, cause this function depend on another function
    // Cause if I want to test the functionality of getCourseHours, I have to assume setCourse is valid firstly
    // I will test setCourse later
    @Test
    public void test_getCourseHours_12()
    {
        gpaObject.setCourse("courseOne", "3", "A");
        assertEquals("getCourseHours_testcase_12_wrong", 3, gpaObject.getCourseHours());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_getCourseGrades_13()
    {
        gpaObject.getCourseName();
    }

    // This part is a little bit tricky, cause this function depend on another function
    // Cause if I want to test the functionality of getCourseGrades, I have to assume setCourse is valid firstly
    // I will test setCourse later
    @Test
    public void test_getCourseGrades_12()
    {
        gpaObject.setCourse("courseOne", "3", "A");
        assertEquals("getCourseGrades_testcase_12_wrong", "A", gpaObject.getCourseGrade());
    }

    @Test
    public void test_setCourse_124()
    {
        gpaObject.setCourse("courseOne", "2", "A");
        assertEquals("setCourse_124_courseName_wrong","courseOne", gpaObject.getCourseName());
        assertEquals("setCourse_124_courseHours_wrong",2, gpaObject.getCourseHours());
        assertEquals("setCourse_124_courseGrades_wrong", "A", gpaObject.getCourseGrade());
    }

    @Test
    public void test_setCourse_134()
    {
        gpaObject.setCourse("courseOne", "test", "A");
        assertEquals("setCourse_134_courseName_wrong", "courseOne", gpaObject.getCourseName());
        assertEquals("setCourse_134_courseHours_wrong",3, gpaObject.getCourseHours());
        assertEquals("setCourse_134_courseGrades_wrong","A", gpaObject.getCourseGrade());
    }

    @Test
    public void test_moreCourses_12()
    {
        boolean moreCourse = gpaObject.moreCourses();
        assertEquals("moreCourse_12_wrong", false, moreCourse);
    }

    // depend on setCourse
    @Test
    public void test_moreCourses_13()
    {
        gpaObject.setCourse("courseOne", "test", "A");
        boolean moreCourse = gpaObject.moreCourses();
        assertEquals("moreCourse_12_wrong", true, moreCourse);
    }

    // 1278 is invalid path
    // 12356278 is invalid path
    // 1234679 is invalid path
    @Test
    public void test_getGpa_1279()
    {
        float gpa = gpaObject.getGpa();
        assertEquals("getGpa_1279_wrong", 0f, gpa, 0.0);
    }

    @Test
    public void test_getGpa_12346278()
    {
        gpaObject.setCourse("courseOne","3","A");
        float gpa = gpaObject.getGpa();
        assertEquals("getGpa_12346278_wrong", 4.0f, gpa, 0.0);
    }

    @Test
    public void test_getGpa_12356279()
    {
        gpaObject.setCourse("courseOne","3","F");
        float gpa = gpaObject.getGpa();
        assertEquals("getGpa_12356279_wrong", 0.0f, gpa, 0.0);
    }

    @Test
    public void test_getGpa_123462356278_extra()
    {
        gpaObject.setCourse("courseOne","3","A");
        gpaObject.setCourse("courseOne","3","F");
        float gpa = gpaObject.getGpa();
        assertEquals("getGpa_123462356278_wrong", 4.0f, gpa, 0.0);
    }

    @Test
    public void test_getGpa_123462346278_extra()
    {
        gpaObject.setCourse("courseOne","3","A");
        gpaObject.setCourse("courseOne","3","A-");
        float gpa = gpaObject.getGpa();
        assertEquals("getGpa_123462346278_wrong", 3.83f, gpa, 0.01);
    }

    @Test
    public void test_getSummaryMessage_1234591011121314151620(){
        gpaObject.setCourse("courseOne", "3", "F");
        gpaObject.setCourse("courseTwo", "3", "C");
        gpaObject.setCourse("courseThree", "3", "C");
        gpaObject.setCourse("courseFour", "3", "C");
        gpaObject.setCourse("courseFive", "3", "B");
        gpaObject.setCourse("courseSix", "3", "B");
        gpaObject.setCourse("courseSeven", "3", "B");
        gpaObject.setCourse("courseEight", "3", "B");
        gpaObject.setCourse("courseNine", "3", "B");
        gpaObject.setCourse("courseTen", "3", "B");
        gpaObject.setCourse("courseEleven", "3", "B");
        gpaObject.setCourse("courseTwelve", "3", "B");
        String result = gpaObject.getSummaryMessage();
        String groundTruth = "Fs cannot be used to graduate, so are not included in the total number of hours accumulated.\n"
                + "Fs are also not included in your GPA calculation.<br/><br/>\n"
                + "Only 2 grades of C are allowed for graduation and 3 were submitted, so the additional Cs are not included in the total number of hours accumulated.<br/><br/>\n"
                + "You have 30 hours, which is enough to graduate with an MS degree.<br/>\n"
                + "However, you do not have the minimum GPA of 3.0.<br/>\n";
        assertEquals("getSummaryMessage_1234591011121314151620_Wrong", groundTruth, result);
    }

    @Test
    public void test_getSummaryMessage_1234691012141520()
    {
        gpaObject.setCourse("courseTwo", "3", "C");
        gpaObject.setCourse("courseThree", "3", "C");
        gpaObject.setCourse("courseFour", "3", "C");
        gpaObject.setCourse("courseFive", "3", "A");
        gpaObject.setCourse("courseSix", "3", "A");
        gpaObject.setCourse("courseSeven", "3", "A");
        gpaObject.setCourse("courseEight", "3", "A");
        gpaObject.setCourse("courseNine", "3", "A");
        gpaObject.setCourse("courseTen", "3", "A");
        gpaObject.setCourse("courseEleven", "3", "A");
        gpaObject.setCourse("courseTwelve", "3", "A");
        String result = gpaObject.getSummaryMessage();
        String groundTruth = "Only 2 grades of C are allowed for graduation and 3 were submitted, so the additional Cs are not included in the total number of hours accumulated.<br/><br/>\n"
                + "You have 30 hours, which is enough to graduate with an MS degree.<br/>\n";
        assertEquals("getSummaryMessage_1234691012141520_Wrong", groundTruth, result);
    }

    @Test
    public void test_getSummaryMessage_123791011121417181920()
    {
        gpaObject.setCourse("courseTwo", "3", "F");
        gpaObject.setCourse("courseThree", "3", "A");
        gpaObject.setCourse("courseFour", "3", "A");
        gpaObject.setCourse("courseFive", "3", "A");
        gpaObject.setCourse("courseSix", "3", "A");
        gpaObject.setCourse("courseSeven", "3", "A");
        gpaObject.setCourse("courseEight", "3", "A");
        String result = gpaObject.getSummaryMessage();
        String groundTruth = "Fs cannot be used to graduate, so are not included in the total number of hours accumulated.\n"
                + "Fs are also not included in your GPA calculation.<br/><br/>\n"
                + "You need 12 more hours to graduate.<br/>\n"
                + "You must average a GPA of 2.0 (at least a C average) in those classes\n"
                + "to graduate with a GPA of 3.0 or above.<br/>\n"
                + "Also, you may only use two grades of C in your MS degree.<br/>\n";
        assertEquals("getSummaryMessage_123791011121417181920_Wrong", groundTruth, result);
    }

    @Test
    public void test_getSummaryMessage_12389101214171920()
    {
        gpaObject.setCourse("courseTwo", "3", "F");
        gpaObject.setCourse("courseThree", "3", "B");
        gpaObject.setCourse("courseFour", "3", "B");
        gpaObject.setCourse("courseFive", "3", "B");
        gpaObject.setCourse("courseSix", "3", "B");
        gpaObject.setCourse("courseSeven", "3", "B-");
        gpaObject.setCourse("courseEight", "3", "B");
        String result = gpaObject.getSummaryMessage();
        String groundTruth = "Fs cannot be used to graduate, so are not included in the total number of hours accumulated.\n"
                + "Fs are also not included in your GPA calculation.<br/><br/>\n"
                + "You need 12 more hours to graduate.<br/>\n"
                + "You must average a GPA of 3.0824997 (at least a B+ average) in those classes\n"
                + "to graduate with a GPA of 3.0 or above.<br/>\n"
                + "Also, you may only use two grades of C in your MS degree.<br/>\n";
        assertEquals("getSummaryMessage_12389101214171920_Wrong", groundTruth, result);
    }

    @Test
    public void test_getHours_12324()
    {
        gpaObject.setCourse("courseTwo", "3", "F");
        gpaObject.setCourse("courseThree", "3", "B");
        gpaObject.setCourse("courseFour", "3", "B");
        gpaObject.setCourse("courseFive", "3", "B");
        assertEquals("getHours_12324_Wrong", 12, gpaObject.getHours());
    }

    @Test
    public void test_getHours_124()
    {
        assertEquals("getHours_124_Wrong", 0, gpaObject.getHours());
    }

    @Test
    public void test_getNeededGPA_12324()
    {
        gpaObject.setCourse("courseTwo", "3", "F");
        gpaObject.setCourse("courseThree", "3", "B");
        gpaObject.setCourse("courseFour", "3", "B");
        gpaObject.setCourse("courseFive", "3", "B");
        assertEquals("getNeededGPA_12324_Wrong", 3.5, gpaObject.getNeededGPA(), 0);
    }



    @Test
    public void test_getNeededGPA_124()
    {
        assertEquals("getNeededGPA_124_Wrong", 3.0, gpaObject.getNeededGPA(), 0);
    }

    @Test
    public void test_getLetterGrade_12()
    {
        assertEquals("getLetterGrade_12_Wrong", "A", gpaObject.getLetterGrade(3.8f));
    }

    @Test
    public void test_getLetterGrade_13()
    {
        assertEquals("getLetterGrade_13_Wrong", "A-", gpaObject.getLetterGrade(3.5f));
    }

    @Test
    public void test_getLetterGrade_14()
    {
        assertEquals("getLetterGrade_14_Wrong", "B+", gpaObject.getLetterGrade(3.2f));
    }

    @Test
    public void test_getLetterGrade_15()
    {
        assertEquals("getLetterGrade_15_Wrong", "B", gpaObject.getLetterGrade(2.9f));
    }

    @Test
    public void test_getLetterGrade_16()
    {
        assertEquals("getLetterGrade_16_Wrong", "B-", gpaObject.getLetterGrade(2.2f));
    }

    @Test
    public void test_getLetterGrade_17()
    {
        assertEquals("getLetterGrade_17_Wrong", "C", gpaObject.getLetterGrade(1.8f));
    }

    @Test
    public void test_getLetterGrade_18()
    {
        assertEquals("getLetterGrade_18_Wrong", "F", gpaObject.getLetterGrade(0.0f));
    }

    @Test
    public void test_getLetterGrade_extra1()
    {
        assertEquals("getLetterGrade_extra1_Wrong", "F", gpaObject.getLetterGrade(-0.6f));
    }

    @Test
    public void test_getLetterGrade_extra2()
    {
        assertEquals("getLetterGrade_extra2_Wrong", "A", gpaObject.getLetterGrade(6.0f));
    }

}
