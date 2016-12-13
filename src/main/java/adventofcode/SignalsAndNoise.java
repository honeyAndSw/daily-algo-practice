package adventofcode;

import java.util.Iterator;

/**
 * Day 6 : Signals And Noise
 * http://adventofcode.com/2016/day/6
 *
 * @author honey.and.sw
 * @since 2016. 12. 13.
 */
public class SignalsAndNoise {

	public String mostCommon(Iterator<String> input) {
		int[][] frequency = frequency(input);

		String result = "";
		for (int i = 0; i < frequency.length; i++) {
			int[] max = new int[]{-1/*index*/, -1/*value*/};
			for (int j = 0; j < frequency[0].length; j++) {
				if (frequency[i][j] > max[1]) {
					max[0] = j;
					max[1] = frequency[i][j];
				}
			}
			result += (char)(max[0] + 'a');
		}
		return result;
	}

	public String leastCommon(Iterator<String> input) {
		int[][] frequency = frequency(input);
		String result = "";
		for (int i = 0; i < frequency.length; i++) {
			int[] min = new int[]{Integer.MAX_VALUE/*index*/, Integer.MAX_VALUE/*value*/};
			for (int j = 0; j < frequency[0].length; j++) {
				if (frequency[i][j] != 0 && frequency[i][j] < min[1]) {
					min[0] = j;
					min[1] = frequency[i][j];
				}
			}
			result += (char)(min[0] + 'a');
		}
		return result;
	}

	private int[][] frequency(Iterator<String> input) {
		String first = input.next();
		int[][] frequency = new int[first.length()][26/*number of alphabets*/];

		updateFrequency(frequency, first);
		while (input.hasNext()) {
			updateFrequency(frequency, input.next());
		}

		return frequency;
	}

	private void updateFrequency(int[][] frequency, String str) {
		for (int i = 0; i < str.length(); i++) {
			frequency[i][str.charAt(i) - 'a'] += 1;
		}
	}
}
