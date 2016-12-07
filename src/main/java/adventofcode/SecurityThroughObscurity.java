package adventofcode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Day 4: Security Through Obscurity
 * http://adventofcode.com/2016/day/4
 *
 * @author honey.and.sw
 * @since 2016. 12. 07.
 */
public class SecurityThroughObscurity {
	private static final Pattern encrypt = Pattern.compile("([a-z\\-]*)(\\d+)\\[(\\w{5})\\]");

	public int sumOfSectorIds(Iterator<String> names) {
		int cnt = 0;
		while (names.hasNext()) {
			cnt += sectorIdIfValid(names.next());
		}
		return cnt;
	}

	private int sectorIdIfValid(String name) {
		Matcher matcher = encrypt.matcher(name);
		matcher.matches();

		Map<Character, Integer> cnt = new HashMap<>();
		String encryped = matcher.group(1);
		for (int i = 0; i < encryped.length(); i++) {
			char ch = encryped.charAt(i);
			if (ch == '-') continue;

			int val = cnt.containsKey(ch) ? cnt.get(ch) + 1 : 1;
			cnt.put(ch, val);
		}

		List<String> cntChar = new ArrayList<>(cnt.size());
		for (Character key : cnt.keySet()) {
			cntChar.add(cnt.get(key).toString() + key);
		}

		Collections.sort(cntChar, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int cnt1 = Integer.parseInt(o1.substring(0, o1.length() - 1));
				int cnt2 = Integer.parseInt(o2.substring(0, o2.length() - 1));

				if (cnt1 != cnt2) return Collections.reverseOrder().compare(cnt1, cnt2);
				else return o1.substring(o1.length() - 1).compareTo(o2.substring(o2.length() - 1));
			}
		});

		String checksum = "";
		for (int i = 0; i < 5; i++) {
			checksum += cntChar.get(i).substring(cntChar.get(i).length() - 1);
		}

		return checksum.equals(matcher.group(3)) ? Integer.parseInt(matcher.group(2)) : 0;
 	}

	public int sectorIdExpectedCodeStored(Iterator<String> names, String code) {
		while (names.hasNext()) {
			int cnt = sectorIdIfValid(names.next());
		}
		return 0;
	}
}
