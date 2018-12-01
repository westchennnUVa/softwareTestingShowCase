package unittest;

/**
 * Created by Westchennn on 9/13/18.
 */

import computeGPA.gpa;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
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


}