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
    // 1235678 is invalid path
    // 1234679 is invalid path
    @Test
    public void test_getGpa_1279()
    {
        float gpa = gpaObject.getGpa();
        assertEquals("getGpa_1279_wrong", 0f, gpa, 0.0);
    }

    @Test
    public void test_getGpa_1234678()
    {
        gpaObject.setCourse("courseOne","3","A");
        float gpa = gpaObject.getGpa();
        assertEquals("getGpa_1234678_wrong", 4.0f, gpa, 0.0);
    }

    @Test
    public void test_getGpa_1235679()
    {
        gpaObject.setCourse("courseOne","3","F");
        float gpa = gpaObject.getGpa();
        assertEquals("getGpa_1234678_wrong", 0.0f, gpa, 0.0);
    }

}