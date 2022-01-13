
import org.junit.Before;
import org.junit.Test;

import jdk.internal.jline.internal.TestAccessible;

import static org.junit.Assert.assertEquals;

public class RosterTest {
    private Roster newRoster;
    String output;
    String expected1;
    String expected2;
    String expected3;

    @Before
    public void setUp(){
        newRoster = new Roster("roster.json");
        output = "";
        expected1 = "Foo Bar 85";
        expected2 = "Lorem Ipsum 83";
        expected3 = "Generic Student 60";
    }

    @Test
    public void testOutputOne(){
        System.out.println("Testing Student1");
        output = newRoster.getStudents().get(0).toString();
        assertEquals("Testing Student1", expected1, output, 0);
    }

    @Test
    public void testOutputTwo(){
        System.out.println("Testing Student2");
        output = newRoster.getStudents().get(1).toString();
        assertEquals("Testing Student2", expected2, output, 0);
    }

    @Test
    public void testOutputThree(){
        System.out.println("Testing Student3");
        output = newRoster.getStudents().get(2).toString();
        assertEquals("Testing Student3", expected3, output, 0);
    }
}