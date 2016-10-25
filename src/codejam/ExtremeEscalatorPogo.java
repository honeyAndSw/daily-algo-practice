package codejam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * ExtremeEscalatorPogo
 * https://code.google.com/codejam/contest/956485/dashboard#s=p2
 *
 * @author naheon
 * @version 2.0.0
 * @since 2016. 10. 25.
 */
public class ExtremeEscalatorPogo {

	public static void main (String [] args) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader("resources/codejam/ExtremeEscalatorPogo_example.in"));
		PrintStream out = System.out;

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

			out.println(String.format("Case #%d: %s\n", i, up(blueSteps)));
		}

		in.close();
		out.close();
	}

	private static String up(int[] blueSteps) {
		int[] possibleHeight = new int[(blueSteps.length - 1) * 2];
		return "";
	}
}
