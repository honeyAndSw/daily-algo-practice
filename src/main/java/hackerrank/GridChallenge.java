package hackerrank;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * GridChallenge
 * https://www.hackerrank.com/challenges/grid-challenge
 *
 * @author naheon
 * @version 2.0.0
 * @since 2016. 10. 31.
 */
public class GridChallenge {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintStream out = System.out;

		int tests = Integer.parseInt(in.nextLine());
		while (tests > 0) {
			int n = Integer.parseInt(in.nextLine());
			char[][] grid = new char[n][];

			/* Construct a grid, each row is sorted. */
			for (int i = 0; i < n; i++) {
				char[] row = (in.nextLine()).toCharArray();
				Arrays.sort(row);
				grid[i] = row;
			}

			out.println(rearrange(grid));
			tests--;
		}
	}

	private static String rearrange(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length - 1; j++) {
				if (grid[j][i] > grid[j + 1][i]) return "NO";
			}
		}
		return "YES";
	}
}
