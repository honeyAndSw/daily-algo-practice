package codejam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * ExtremeEscalatorPogo
 * https://code.google.com/codejam/contest/956485/dashboard#s=p2
 *
 * @author honey.and.sw
 * @version 2.0.0
 * @since 2016. 10. 25.
 */
public class ExtremeEscalatorPogo {

	public static void main (String [] args) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader("resources/codejam/ExtremeEscalatorPogo_small.in"));
		PrintStream out = new PrintStream("resources/codejam/ExtremeEscalatorPogo_small.out");
		// PrintStream out = System.out;

		/* # of tests */
		int t = Integer.parseInt(in.nextLine());
		for (int i = 1; i <= t; i++) {
			String s = in.nextLine();
			String[] array = s.split(" ");

			/* # of steps */
			int n = Integer.parseInt(array[0]);
			/* # of blue steps */
			int k = Integer.parseInt(array[1]);

			int[] blueSteps = new int[k];
			for (int j = 0; j < k; j++) {
				blueSteps[j] = Integer.parseInt(array[j + 2]);
			}

			out.println(String.format("Case #%d: %s", i, up(n, blueSteps)));
		}

		in.close();
		out.close();
	}

	private static boolean canMove(int[] diff, int i) {
		return diff[i] == -1 || diff[i] == 0 || diff[i] == 1;
	}

	private static String up(int length, int[] blueSteps) {
		/* Extend blueSteps as an escalator cycles. */
		int[] doubleblues = new int[blueSteps.length * 2];
		for (int i = 0; i < blueSteps.length; i++) {
			doubleblues[i] = blueSteps[i];
			doubleblues[i + blueSteps.length] = blueSteps[i] + length;
		}

		int[] heights = new int[doubleblues.length - 1];
		for (int i = 0; i < doubleblues.length - 1; i++) {
			heights[i] = doubleblues[i + 1] - doubleblues[i];
		}

		int[] diff = new int[heights.length - 1];
		for (int i = 0; i < heights.length - 1; i++) {
			diff[i] = heights[i + 1] - heights[i];
		}

		/* Find start(slow), end(end, exclusive) index of sequences where diff is -1, 0, or 1. */
		int slow = 0, fast = 0, longest = 0;
		while (fast < diff.length) {
			if (canMove(diff, fast)) {
				fast++;
			} else {
				longest = Math.max(longest, fast - slow);
				slow = ++fast;
			}
		}

		/* Make result. */
		if (slow == 0 && fast == diff.length) return "infinity";
		else if (longest == 0) {
			for (int i = 0; i < heights.length; i++) {
				// Can start the first step, a height of 1.
				if (heights[i] == 1)
					return "2";
			}
			return "1";
		} else return (longest + 2) + "";
	}
}
