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
			int zero = 0;
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
				if (a[i] == 0) zero++;
			}

			if (zero == n) { // Special case : all 0s.
				System.out.println(n - 1);
			} else {
				System.out.println(score(a, 0, n - 1));
			}
		}
	}

	public static int score(int[] a, int start, int end) {
		if (a.length <= 1 || start == end) return 0;

		int front = start, back = end, diff = a[front] - a[back];
		while (front < back) {
			if (diff == 0) {
				if (++front < --back) diff += a[front] - a[back];
			} else if (diff > 0) {
				diff -= a[--back];
			} else {
				diff += a[++front];
			}
		}

		if (diff == 0) {
			if ((front == back && a[front] == 0) || (front > back)) {
				return 1 + Math.max(score(a, start, back), score(a, front, end));
			}
		}
		return 0;
	}
}
