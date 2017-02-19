package codejam.qual2016;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 2. 19.
 */
public class CountingSheepTest {
    @Test
    public void test1() throws Exception {
        assertEquals(-1, new CountingSheep().fallAsleep(0));
        assertEquals(90, new CountingSheep().fallAsleep(2));
        assertEquals(110, new CountingSheep().fallAsleep(11));
        assertEquals(5076, new CountingSheep().fallAsleep(1692));
    }

    @Test
    public void test2() throws Exception {
        assertEquals(10, new CountingSheep().fallAsleep(1));
    }
}