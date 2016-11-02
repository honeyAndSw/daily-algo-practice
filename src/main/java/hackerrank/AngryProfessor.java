package hackerrank;

import java.util.Scanner;

/**
 * AngryProfessor
 * https://www.hackerrank.com/challenges/angry-professor
 *
 * @author honey.and.sw
 * @version 2.0.0
 * @since 2016. 11. 02.
 */
public class AngryProfessor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int k = in.nextInt();
			for (int i = 0; i < n; i++) {
				if (in.nextInt() <= 0) k--;
			}
			System.out.println((k <= 0) ? "NO" : "YES");
		}
	}

}
