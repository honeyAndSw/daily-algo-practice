package adventofcode;

import java.util.Iterator;

/**
 * Day7 : Internet Protocol Version7
 * http://adventofcode.com/2016/day/7
 *
 * @author naheon
 * @since 2016. 12. 13.
 */
public class InternetProtocolVersion7 {
	public int countTls(Iterator<String> itr) {
		int cnt = 0;
		while (itr.hasNext()) {
			cnt += supportsTls(itr.next()) ? 1 : 0;
		}
		return cnt;
	}

	public boolean supportsTls(String ip) {
		int abbaCnt = 0;
		int slow = 0, fast = 0;
		boolean isHypernet = false;

		while (fast < ip.length()) {
			if (!isHypernet && ip.charAt(fast) == '[') {
				abbaCnt += isAbba(ip.substring(slow, fast)) ? 1 : 0;
				// Start hypernet sequences
				isHypernet = true;
				slow = fast + 1;
			} else if (isHypernet && ip.charAt(fast) == ']') {
				// Invalid ABBA.
				if (isAbba(ip.substring(slow, fast))) return false;
				// Finish hypernet sequences
				isHypernet = false;
				slow = fast + 1;
			}
			fast++;
		}

		return abbaCnt == 1;
	}

	public boolean isAbba(String str) {
		int slow = 0, fast = str.length() - 1, cnt = 0;

		while (slow < fast) {
			if (str.charAt(slow) == str.charAt(fast)) {
				if (fast - slow == 3 &&
						str.charAt(slow + 1) == str.charAt(fast - 1) &&
						str.charAt(slow) != str.charAt(slow + 1)) {
					return true;
				}
			}
			slow++;
			fast--;
		}

		return false;
	}
}
