package topcoder;

import java.util.*;

/**
 * GrafixMask
 * https://community.topcoder.com/stat?c=problem_statement&pm=2998&rd=5857
 *
 * @author naheon
 * @version 2.0.0
 * @since 2016. 10. 27.
 */
public class GrafixMask {

	static boolean[][] layer = new boolean[600][400];

	public static void main(String[] args) {
		int[] output1 = sortedAreas(new String[] {"0 292 399 307"});
		System.out.println(Arrays.toString(output1));
	}

	public static int[] sortedAreas(String[] input) {
		for (int i = 0; i < 600; i++) {
			for (int j = 0; j < 400; j++) {
				layer[i][j] = false;
			}
		}

		for (String in : input) {
			int[] rec = parseInput(in);
			for (int i = rec[1]; i <= rec[3]; i++) {
				for (int j = rec[0]; j < rec[2]; j++) {
					layer[i][j] = true;
				}
			}
		}

		List<Integer> areas = new ArrayList<>();
		for (int i = 0; i < 600; i++) {
			for (int j = 0; j < 400; j++) {
				if (!layer[i][j]) {
					areas.add(startFill(i, j));
				}
			}
		}

		Collections.sort(areas);
		int[] result = new int[areas.size()];
		for (int i = 0; i < areas.size(); i++) {
			result[i] = areas.get(i);
		}
		return result;
	}

	static class P {
		int x, y;

		public P(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static Integer startFill(int x, int y) {
		int result = 0;

		Stack<P> stack = new Stack<>();
		stack.push(new P(x, y));

		while (stack.size() > 0) {
			P p = stack.pop();

			if (p.x < 0 || p.x >= 600 || p.y < 0 || p.y >= 400 || layer[p.x][p.y]) continue;

			result++;
			layer[p.x][p.y] = true;

			stack.push(new P(p.x - 1, p.y));
			stack.push(new P(p.x + 1, p.y));
			stack.push(new P(p.x, p.y - 1));
			stack.push(new P(p.x, p.y + 1));
		}

		return result;
	}

	private static int[] parseInput(String in) {
		String[] split = in.split(" ");
		int[] ret = new int[split.length];
		for (int i = 0; i < split.length; i++) {
			ret[i] = Integer.parseInt(split[i]);
		}
		return ret;
	}
}
