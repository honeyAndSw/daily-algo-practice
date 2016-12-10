package geeksforgeeks;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2016. 11. 14.
 */
public class NumberFormationTest {
    @Test
    public void test1() throws Exception {
        Integer[] expected = {4,5,6,45,54,56,65,46,64,456,465,546,564,645,654};
        Integer[] result = NumberFormation.permSum(new int[]{4,5,6}, 0).toArray(new Integer[expected.length]);
        Arrays.sort(result);
        Arrays.sort(expected);

        assertTrue(Arrays.equals(expected, result));
    }
}