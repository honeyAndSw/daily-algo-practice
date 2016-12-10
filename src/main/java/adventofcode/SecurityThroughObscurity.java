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
	private static final char[] alphabet = new char[]{
		'a', 'b', 'c', 'd', 'e',
		'f', 'g', 'h', 'i', 'j',
		'k', 'l', 'm', 'n', 'o',
		'p', 'q', 'r', 's', 't',
		'u', 'v', 'w', 'x', 'y', 'z'};

	public int sumOfSectorIds(Iterator<String> names) {
		int cnt = 0;
		while (names.hasNext()) {
			cnt += sectorIdIfValid(names.next(), null);
		}
		return cnt;
	}

	public int sectorIdExpectedCodeStored(Iterator<String> names, String code) {
		while (names.hasNext()) {
			String name = names.next();
			int cnt = sectorIdIfValid(name, code);
			if (cnt > 0) {
				return cnt;
			}
		}
		return 0;
	}

	private int sectorIdIfValid(String name, String expected) {
		Matcher matcher = encrypt.matcher(name);
		matcher.matches();

		String encrypted = matcher.group(1);
		int id = Integer.parseInt(matcher.group(2));

		Map<Character, Integer> cnt = new HashMap<>();
		for (int i = 0; i < encrypted.length(); i++) {
			char ch = encrypted.charAt(i);
			if (ch == '-') continue;
			cnt.put(ch, cnt.containsKey(ch) ? cnt.get(ch) + 1 : 1);
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

		if (expected == null) {
			// Part 1
			return checksum.equals(matcher.group(3)) ? id : 0;
		} else {
			// Part 2
			int shift = id % alphabet.length;
			String real = "";
			for (int i = 0; i < encrypted.length(); i++) {
				if (encrypted.charAt(i) == '-') real += " ";
				else real += alphabet[(encrypted.charAt(i) - 'a' + shift) % alphabet.length];
			}
			return real.contains(expected) ? id : 0;
		}
 	}
}
