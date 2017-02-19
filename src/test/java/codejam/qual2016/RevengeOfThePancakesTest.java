package codejam.qual2016;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 2. 19.
 */
public class RevengeOfThePancakesTest {

    private RevengeOfThePancakes revengePancakes = new RevengeOfThePancakes();

    @Test
    public void test1() throws Exception {
        assertEquals(0, revengePancakes.flipToHappySide("+"));
        assertEquals(1, revengePancakes.flipToHappySide("-"));
        assertEquals(1, revengePancakes.flipToHappySide("-+"));
        assertEquals(2, revengePancakes.flipToHappySide("+-"));
        assertEquals(0, revengePancakes.flipToHappySide("+++"));
        assertEquals(3, revengePancakes.flipToHappySide("--+-"));
    }
}