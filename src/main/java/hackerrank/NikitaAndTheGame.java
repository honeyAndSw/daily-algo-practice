package hackerrank;

import java.util.Scanner;

/**
 * NikitaAndTheGame
 * https://www.hackerrank.com/challenges/array-splitting
 *
 * @author honey.and.sw
 * @version 2.0.0
 * @since 2016. 11. 02.
 */
public class NikitaAndTheGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) a[i] = in.nextInt();
			System.out.println(score(a, 0, n - 1));
		}
	}

	public static int score(int[] a, int start, int end) {
		if (a.length <= 1) return 0;

		int front = start, back = end, diff = a[start] - a[end];
		while (front < back) {
			if (diff == 0 && front == back - 1) {
				// System.out.println("front:" + front + ", back:" + back);
				return 1 + Math.max(
					score(a, start, back - 1), score(a, back, end));
			}

			if (diff == 0) {
				diff += a[++front] - a[--back];
			} else if (diff > 0) {
				diff -= a[--back];
			} else {
				diff += a[++front];
			}
		}

		// cannot partition a.
		return 0;
	}
}
