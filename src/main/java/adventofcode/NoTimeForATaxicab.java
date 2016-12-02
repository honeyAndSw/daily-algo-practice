package adventofcode;

import java.util.Arrays;

/**
 * NoTimeForATaxicab
 *
 * Day 1 : No Time for a Taxicab
 * http://adventofcode.com/2016/day/1
 *
 * @author naheon
 * @version 2.0.0
 * @since 2016. 12. 02.
 */
public class NoTimeForATaxicab {

	int MAX_LEN = 300; // Assumed value

	public class Position {
		int x = 0, y = 0;
		char dir = 'N';

		public void move(char turn, int b) {
			switch (dir) {
				case 'N':
					dir = (turn == 'L') ? 'W' : 'E';
					x = (turn == 'L') ? x - b : x + b;
					break;
				case 'E':
					dir = (turn == 'L') ? 'N' : 'S';
					y = (turn == 'L') ? y + b : y - b;
					break;
				case 'S': // Reverse of 'N'
					dir = 'N';
					move(turn == 'L' ? 'R' : 'L', b);
					break;
				case 'W': // Reverse of 'E';
					dir = 'E';
					move(turn == 'L' ? 'R' : 'L', b);
					break;
			}
		}

		public int blocks() {
			return Math.abs(x) + Math.abs(y);
		}
	}

	public class PositionCheckVisit {
		int x = 0, y = 0;
		int tx = 0, ty = 0;
		char dir = 'N';

		boolean[][] grid = new boolean[MAX_LEN * 2][MAX_LEN * 2];
		int center = MAX_LEN;

		/**
		 * Returns true if find a location visited twice.
		 *
		 * @param turn
		 * @param b
		 * @return
		 */
		public boolean move(char turn, int b) {
			switch (dir) {
				case 'N':
					dir = (turn == 'L') ? 'W' : 'E';
					int nx = (turn == 'L') ? x - b : x + b;

					for (int i = Math.min(nx, x); i <= Math.max(nx, x); i++) {
						if (grid[y + center][i + center] && (i != x)) {
							tx = i;
							ty = y;
							return true;
						} else {
							grid[y + center][i + center] = true;
						}
					}

					x = nx;
					return false;
				case 'E':
					dir = (turn == 'L') ? 'N' : 'S';
					int ny = (turn == 'L') ? y + b : y - b;

					for (int i = Math.min(ny, y); i <= Math.max(ny, y); i++) {
						if (grid[i + center][x + center] && (i != y)) {
							tx = x;
							ty = i;
							return true;
						} else {
							grid[i + center][x + center] = true;
						}
					}

					y = ny;
					return false;
				case 'S': // Reverse of 'N'
					dir = 'N';
					return move(turn == 'L' ? 'R' : 'L', b);
				case 'W': // Reverse of 'E';
					dir = 'E';
					return move(turn == 'L' ? 'R' : 'L', b);
				default:
					return false;
			}
		}

		public int blocks() {
			return Math.abs(tx) + Math.abs(ty);
		}

		public void grid() {
			for (int i = 0; i < grid.length; i++) {
				System.out.println(Arrays.toString(grid[i]));
			}
		}
	}

	public int blocksToHq(String[] input) {
		Position pos = new Position();

		for (String i : input) {
			char[] d = i.substring(0, 1).toCharArray();
			int b = Integer.parseInt(i.substring(1, i.length()));
			pos.move(d[0], b);
		}
		return pos.blocks();
	}

	public int blocksToVisitTwice(String[] input) {
		PositionCheckVisit pos = new PositionCheckVisit();

		for (String i : input) {
			char[] d = i.substring(0, 1).toCharArray();
			int b = Integer.parseInt(i.substring(1, i.length()));

			boolean visitTwice = pos.move(d[0], b);
			if (visitTwice) {
				return pos.blocks();
			}
		}

		return pos.blocks();
	}
}
