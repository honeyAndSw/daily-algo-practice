package adventofcode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Day 3 : Squares With Three Sides
 * http://adventofcode.com/2016/day/3
 *
 * @author honey.and.sw
 * @since 2016. 12. 04.
 */
public class SquaresWithThreeSides {

	public int trianglesInRow() throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader("resources/adventofcode/day3"));
		int cnt = 0;

		while (in.hasNext()) {
			int[] triangle = new int[3];
			String[] split = in.nextLine().trim().split("\\s");
			int j = 0;
			for (String s : split) {
				if (!"".equals(s)) triangle[j++] = Integer.parseInt(s);
			}

			if (isTriangle(triangle)) cnt++;
		}

		return cnt;
	}

	private boolean isTriangle(int[] t) {
		Arrays.sort(t);
		return (t[0] + t[1] > t[2]);
	}

	public int trianglesInColumn(String file) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader("resources/adventofcode/" + file));
		int cnt = 0;
		int offset = 0;
		int[][] triangles = new int[3][3]; // three groups of triangle

		while (in.hasNext()) {
			if (offset == 3) {
				for (int[] triangle : triangles) {
					if (isTriangle(triangle)) cnt++;
				}
				// Start new set
				offset = 0;
				triangles = new int[3][3];
			} else {
				String[] split = in.nextLine().trim().split("\\s");
				int j = 0;
				for (String s : split) {
					if (!"".equals(s)) triangles[j++][offset] = Integer.parseInt(s);
				}
				offset++;
			}
		}

		// Last three rows
		for (int[] triangle : triangles) {
			if (isTriangle(triangle)) cnt++;
		}

		return cnt;
	}
}
