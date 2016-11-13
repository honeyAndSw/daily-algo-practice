package geeksforgeeks;

import java.util.Scanner;

/**
 * Modified Fibonacci
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=1428
 *
 * Created by honey.and.sw on 2016. 11. 13.
 */
public class ModifiedFibonacci {
    private static long M = 1000000007;

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            long a = in.nextLong(), b = in.nextLong(), c = in.nextLong();
            System.out.println(fibo(a+b, b+c, n));
        }
    }

    public static long fibo(long f1, long f2, long n) {
        int modN = (int)((n-1) % 6);
        long[] cache = {f1 % M, f2 % M, (f2 - f1) % M};

        long result = (modN < 3) ? cache[modN] : -cache[modN%3];
        while (result < 0) result += M;
        return result;
    }
}