package geeksforgeeks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2016. 11. 13.
 */
public class ModifiedFibonacciTest {
    @Test
    public void test1() throws Exception {
        long n = 46930887, a = 23465443, b = 15643629, c = 11732721;
        assertEquals(988267285, ModifiedFibonacci.fibo(a + b, b + c, n));
    }

    @Test
    public void test2() throws Exception {
        long n = 81692778, a = 40846389, b = 27230926, c = 20423194;
        assertEquals(20423195, ModifiedFibonacci.fibo(a + b, b + c, n));
    }
}