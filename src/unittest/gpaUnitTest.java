package unittest;

/**
 * Created by Westchennn on 9/13/18.
 */

import computeGPA.gpa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
    private WebDriver driver;
    private String url = "http://localhost:8080/calculategpa.jsp";
    gpa gpaObject;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/WestChen/IdeaProjects/modelBasedTestingGpa/src/chromedriver");    // specify path the the driver
        driver = new ChromeDriver();    // create an instance of the web browser and open it
        driver.get(url);
        gpaObject = new gpa();
    }

    @After
    public void teardown()
    {
        driver.quit();
    }

    public void sleep()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.print(e.toString());
        }
    }

    @Test
    public void test_getGradeValue_129_1()
    {
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        element.click();
        driver.findElement(By.name("submitCourses")).click();
        sleep();
        float gradeValue = gpaObject.getGradeValue("A+");
        boolean gradeValueCorrect = driver.getPageSource().contains("Your current GPA is: " +gradeValue);
        assertEquals("getGradeValue_testcase_129_wrong", true, gradeValueCorrect);
    }

    @Test
    public void test_getGradeValue_129_2()
    {
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        element.click();
        driver.findElement(By.name("submitCourses")).click();
        sleep();
        float gradeValue = gpaObject.getGradeValue("A");
        boolean gradeValueCorrect = driver.getPageSource().contains("Your current GPA is: " +gradeValue);
        assertEquals("getGradeValue_testcase_129_wrong", true, gradeValueCorrect);
    }

    @Test
    public void test_getGradeValue_139()
    {
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
        element.click();
        driver.findElement(By.name("submitCourses")).click();
        sleep();
        float gradeValue = gpaObject.getGradeValue("A-");
        boolean gradeValueCorrect = driver.getPageSource().contains("Your current GPA is: " +gradeValue);
        assertEquals("getGradeValue_testcase_139_wrong", true, gradeValueCorrect);
    }

    @Test
    public void test_getGradeValue_149()
    {
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio'])[4]"));
        element.click();
        driver.findElement(By.name("submitCourses")).click();
        sleep();
        float gradeValue = gpaObject.getGradeValue("B+");
        boolean gradeValueCorrect = driver.getPageSource().contains("Your current GPA is: " +gradeValue);
        assertEquals("getGradeValue_testcase_149_wrong", true, gradeValueCorrect);
    }

    @Test
    public void test_getGradeValue_159()
    {
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio'])[5]"));
        element.click();
        driver.findElement(By.name("submitCourses")).click();
        sleep();
        float gradeValue = gpaObject.getGradeValue("B");
        boolean gradeValueCorrect = driver.getPageSource().contains("Your current GPA is: " +gradeValue);
        assertEquals("getGradeValue_testcase_159_wrong", true, gradeValueCorrect);
    }

    @Test
    public void test_getGradeValue_169()
    {
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio'])[6]"));
        element.click();
        driver.findElement(By.name("submitCourses")).click();
        sleep();
        float gradeValue = gpaObject.getGradeValue("B-");
        boolean gradeValueCorrect = driver.getPageSource().contains("Your current GPA is: " +gradeValue);
        assertEquals("getGradeValue_testcase_169_wrong", true, gradeValueCorrect);
    }

    @Test
    public void test_getGradeValue_179()
    {
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio'])[7]"));
        element.click();
        driver.findElement(By.name("submitCourses")).click();
        sleep();
        float gradeValue = gpaObject.getGradeValue("C");
        boolean gradeValueCorrect = driver.getPageSource().contains("Your current GPA is: " +gradeValue);
        assertEquals("getGradeValue_testcase_179_wrong", true, gradeValueCorrect);
    }

    @Test
    public void test_getGradeValue_189()
    {
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio'])[8]"));
        element.click();
        driver.findElement(By.name("submitCourses")).click();
        sleep();
        float gradeValue = gpaObject.getGradeValue("F");
        boolean gradeValueCorrect = driver.getPageSource().contains("Your current GPA is: " +gradeValue);
        assertEquals("getGradeValue_testcase_189_wrong", true, gradeValueCorrect);
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
        driver.findElement(By.name("courseName1")).sendKeys("courseNameTest");
        gpaObject.setCourse("courseNameTest", "3", "A");
        driver.findElement(By.name("submitCourses")).click();
        boolean getCourseNameCorrect = driver.getPageSource().contains(gpaObject.getCourseName());
        assertEquals("getCourseName_testcase_12_wrong",true, getCourseNameCorrect);
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
//        driver.findElement(By.name("courseCredit1")).sendKeys("2");
        gpaObject.setCourse("courseOne", "3", "A");
        driver.findElement(By.name("submitCourses")).click();
        boolean getCourseHourCorrect = driver.getPageSource().contains(String.valueOf(gpaObject.getCourseHours()));
        assertEquals("getCourseHours_testcase_12_wrong", true, getCourseHourCorrect);
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
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        element.click();
        driver.findElement(By.name("submitCourses")).click();
        sleep();
        gpaObject.setCourse("courseOne", "3", "A");
        assertEquals("getCourseGrades_testcase_12_wrong", "A", gpaObject.getCourseGrade());
        boolean getGradeCorrect = driver.findElement(By.xpath("(//input[@type='radio'])[2]")).isSelected();
        assertEquals("getCourseGrades_testcase_12_wrong", true, getGradeCorrect);
    }

    @Test
    public void test_setCourse_124()
    {
        driver.findElement(By.name("courseName1")).sendKeys("courseNameTest");
//        driver.findElement(By.name("courseCredit1")).sendKeys("2");
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        element.click();
        driver.findElement(By.name("submitCourses")).click();

        gpaObject.setCourse("courseNameTest", "3", "A");
        boolean getCourseNameCorrect = driver.getPageSource().contains(gpaObject.getCourseName());
        boolean getCourseHourCorrect = driver.getPageSource().contains(String.valueOf(gpaObject.getCourseHours()));
        boolean getCourseGradeCorrect = driver.findElement(By.xpath("(//input[@type='radio'])[2]")).isSelected();

        assertEquals("setCourse_124_courseName_wrong",true, getCourseNameCorrect);
        assertEquals("setCourse_124_courseName_wrong", true, getCourseHourCorrect);
        assertEquals("setCourse_124_courseName_wrong", true, getCourseGradeCorrect);
    }

    @Test
    public void test_setCourse_134()
    {

        driver.findElement(By.name("courseName1")).sendKeys("courseNameTest");
        driver.findElement(By.name("courseCredit1")).sendKeys("test");
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        element.click();
        driver.findElement(By.name("submitCourses")).click();

        gpaObject.setCourse("courseNameTest", "test", "A");
        boolean getCourseNameCorrect = driver.getPageSource().contains(gpaObject.getCourseName());
        boolean getCourseHourCorrect = driver.getPageSource().contains(String.valueOf(gpaObject.getCourseHours()));
        boolean getCourseGradeCorrect = driver.findElement(By.xpath("(//input[@type='radio'])[2]")).isSelected();

        assertEquals("setCourse_134_courseName_wrong",true, getCourseNameCorrect);
        assertEquals("setCourse_134_courseName_wrong", true, getCourseHourCorrect);
        assertEquals("setCourse_134_courseName_wrong", true, getCourseGradeCorrect);
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
        driver.findElement(By.name("courseName1")).sendKeys("courseNameTest");
        driver.findElement(By.name("courseCredit1")).sendKeys("test");
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        element.click();
        WebElement addMore = driver.findElement(By.tagName("a"));
        addMore.click();
        boolean webMoreCourse = driver.findElement(By.name("courseName2")).isDisplayed();

        gpaObject.setCourse("courseOne", "test", "A");
        boolean moreCourse = gpaObject.moreCourses();

        assertEquals("moreCourse_12_wrong", moreCourse, webMoreCourse);
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
        driver.findElement(By.name("courseName1")).sendKeys("courseNameTest");
//        driver.findElement(By.name("courseCredit1")).sendKeys("3");
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        element.click();
        driver.findElement(By.name("submitCourses")).click();
        sleep();
        gpaObject.setCourse("courseNameTest","3","A+");
        float gpa = gpaObject.getGpa();
        boolean gradeValueCorrect = driver.getPageSource().contains("Your current GPA is: " + gpa);
        assertEquals("getGpa_12346278_wrong", true, gradeValueCorrect);
    }

    @Test
    public void test_getGpa_12356279()
    {
        driver.findElement(By.name("courseName1")).sendKeys("courseNameTest");
//        driver.findElement(By.name("courseCredit1")).sendKeys("3");
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio'])[8]"));
        element.click();
        driver.findElement(By.name("submitCourses")).click();
        sleep();

        gpaObject.setCourse("courseOne","3","F");
        float gpa = gpaObject.getGpa();
        boolean gradeValueCorrect = driver.getPageSource().contains("Your current GPA is: " + gpa);
        assertEquals("getGpa_12356279_wrong", true, gradeValueCorrect);
    }

    @Test
    public void test_getGpa_123462356278_extra()
    {
        driver.findElement(By.name("courseName1")).sendKeys("courseNameTest");
//        driver.findElement(By.name("courseCredit1")).sendKeys("3");
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        element.click();
        WebElement addMore = driver.findElement(By.tagName("a"));
        addMore.click();
        driver.findElement(By.name("courseName2")).sendKeys("courseNameTest");
//        driver.findElement(By.name("courseCredit2")).sendKeys("3");
        WebElement element2 = driver.findElement(By.xpath("(//input[@type='radio'])[16]"));
        element2.click();

        driver.findElement(By.name("submitCourses")).click();
        sleep();

        gpaObject.setCourse("courseOne","3","A");
        gpaObject.setCourse("courseOne","3","F");
        float gpa = gpaObject.getGpa();
        boolean gradeValueCorrect = driver.getPageSource().contains("Your current GPA is: " + gpa);
        assertEquals("getGpa_123462356278_wrong", true, gradeValueCorrect);
    }

    @Test
    public void test_getGpa_123462346278_extra()
    {
        driver.findElement(By.name("courseName1")).sendKeys("courseNameTest");
//        driver.findElement(By.name("courseCredit1")).sendKeys("3");
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        element.click();
        WebElement addMore = driver.findElement(By.tagName("a"));
        addMore.click();
        driver.findElement(By.name("courseName2")).sendKeys("courseNameTest");
//        driver.findElement(By.name("courseCredit2")).sendKeys("3");
        WebElement element2 = driver.findElement(By.xpath("(//input[@type='radio'])[10]"));
        element2.click();

        driver.findElement(By.name("submitCourses")).click();
        sleep();

        gpaObject.setCourse("courseOne","3","A");
        gpaObject.setCourse("courseOne","3","A");
        float gpa = gpaObject.getGpa();
        boolean gradeValueCorrect = driver.getPageSource().contains("Your current GPA is: " + gpa);
        assertEquals("getGpa_123462346278_wrong", true, gradeValueCorrect);

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
