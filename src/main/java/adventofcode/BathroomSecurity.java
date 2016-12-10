package adventofcode;

/**
 * Day 2 : Bathroom Security
 * http://adventofcode.com/2016/day/2
 *
 * @author honey.and.sw
 * @version 2.0.0
 * @since 2016. 12. 04.
 */
public class BathroomSecurity {

	String[] instructions;

	public BathroomSecurity(String[] instructions) {
		this.instructions = instructions;
	}

	public String numericPassword() {
		int prev = 4; // means starting from '5'
		StringBuilder pw = new StringBuilder();

		for (String inst : instructions) {
			for (char ch : inst.toCharArray()) {
				switch (ch) {
					case 'U':
						if (prev - 3 >= 0) prev -= 3;
						break;
					case 'D':
						if (prev + 3 <= 8) prev += 3;
						break;
					case 'L':
						int min = (prev / 3) * 3;
						if (prev - 1 >= min && prev - 1 <= min + 2) prev -= 1;
						break;
					case 'R':
						min = (prev / 3) * 3;
						if (prev + 1 >= min && prev + 1 <= min + 2) prev += 1;
						break;
				}
			}
			pw.append(prev + 1);
		}

		return pw.toString();
	}

	public String alphaNumericPassword() {
		char[] keypad = new char[]{
			'X', 'X', '1', 'X', 'X',
			'X', '2', '3', '4', 'X',
			'5', '6', '7', '8', '9',
			'X', 'A', 'B', 'C', 'X',
			'X', 'X', 'D', 'X', 'X'};

		int prev = 10; // means starting from '5'
		StringBuffer sb = new StringBuffer();

		for (String inst : instructions) {
			for (char ch : inst.toCharArray()) {
				switch (ch) {
					case 'U':
						if (prev - 5 >= 0 && keypad[prev - 5] != 'X') prev -= 5;
						break;
					case 'D':
						if (prev + 5 <= 24 && keypad[prev + 5] != 'X') prev += 5;
						break;
					case 'L':
						int min = (prev / 5) * 5;
						if (prev - 1 >= min && prev - 1 <= min + 4 && keypad[prev - 1] != 'X') prev -= 1;
						break;
					case 'R':
						min = (prev / 5) * 5;
						if (prev + 1 >= min && prev + 1 <= min + 4 && keypad[prev + 1] != 'X') prev += 1;
						break;
				}
			}
			sb.append(keypad[prev]);
		}

		return sb.toString();
	}
}
