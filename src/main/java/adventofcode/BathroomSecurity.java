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

	public String password() {
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
}
