package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by honey.and.sw on 2016. 11. 14.
 */
public class NumberFormation {
    private static int M = 1000000007;

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int x = input.nextInt(), y = input.nextInt(), z = input.nextInt();
            int[] nums = new int[x + y + z];
            for (int i = 0; i < nums.length; i++) {
                if (i < x) nums[i] = 4;
                else if (i < x + y) nums[i] = 5;
                else nums[i] = 6;
            }

            int sum = 0;
            for (int s : permSum(nums, 0)) {
                sum = (sum + s) % M;
            }
            System.out.println(sum % M);
        }
    }

    public static List<Integer> permSum(int[] nums, int start) {
        if (start == nums.length) return new ArrayList<>();

        int self = nums[start];
        List<Integer> sums = permSum(nums, start + 1);

        List<Integer> extend = new ArrayList<>();
        extend.add(self);

        for (Integer sum : sums) {
            extend.add(sum);
            int size = (int)Math.log10(sum) + 1;
            for (int i = 0; i <= size; i++) {
                extend.add(
                    (int)((int)(sum / Math.pow(10, i)) * Math.pow(10, i + 1)) +
                    (int)(self * Math.pow(10, i)) +
                    (int)(sum % Math.pow(10, i))
                );
            }
        }
        return extend;
    }
}
