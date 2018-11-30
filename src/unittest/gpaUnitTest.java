package unittest;

/**
 * Created by Westchennn on 9/13/18.
 */

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * 1. test1 passes
 * 2. test2 passes
 * 3. test2 includes not only one method, which is not good at all
 * 4. Split remove function and add different value function into two test case.
 */


public class gpaUnitTest
{
    Set s = new HashSet();

    @Before
    public void setUp()
    {
        s = new HashSet();
        s.add("cat");
        s.add("dog");
    }

    @Test
    public void test1()
    {
        s.add("cat");
        assertTrue("Size of s is still 2", s.size()==2);
    }

    @Test
    public void test2()
    {
        s.remove("cat");
        assertTrue("Size of s is now 1", s.size()==1);
        s.add("elephant");
        assertTrue("Size of s is now 2", s.size()==2);
    }
}