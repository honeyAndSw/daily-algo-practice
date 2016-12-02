package adventofcode;

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

	public class Position {
		int x = 0;
		int y = 0;
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
				case 'S':
					dir = (turn == 'L') ? 'E' : 'W';
					x = (turn == 'L') ? x + b : x - b;
					break;
				case 'W':
					dir = (turn == 'L') ? 'S' : 'N';
					y = (turn == 'L') ? y - b : y + b;
					break;
			}
		}

		public int blocks() {
			return Math.abs(x) + Math.abs(y);
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
}
