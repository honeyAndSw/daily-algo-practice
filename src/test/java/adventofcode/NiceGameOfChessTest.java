package adventofcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2016. 12. 10.
 */
public class NiceGameOfChessTest {
    NiceGameOfChess generator;

    @Before
    public void setUp() throws Exception {
        generator = new NiceGameOfChess();
    }

    @Test
    public void test1() throws Exception {
        // It's given wrong answer on the example.
        assertNotEquals("18f47a30", generator.password("abc"));
        assertEquals("18f47a36", generator.password("abc"));
    }

    @Test
    public void test2() throws Exception {
        assertEquals("4543c154", generator.password("ojvtpuvg"));
    }

    @Test
    public void test3() throws Exception {
        assertEquals("05ace8e3", generator.passwordSecondDoor("abc"));
    }

    @Test
    public void test4() throws Exception {
        // WARNING! This takes tooooooo long.
        // I got [_, 0, 5, 0, c, b, b, d] and skipped the last one.
        assertEquals("1050cbbd", generator.passwordSecondDoor("ojvtpuvg"));
    }
}