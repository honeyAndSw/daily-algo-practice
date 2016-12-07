package adventofcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * SecurityThroughObscurityTest
 *
 * @author naheon
 * @version 2.0.0
 * @since 2016. 12. 07.
 */
public class SecurityThroughObscurityTest {
	SecurityThroughObscurity sto = new SecurityThroughObscurity();

	@Test
	public void test0() throws Exception {
		Pattern encrypt = Pattern.compile("([a-z\\-]*)(\\d+)\\[(\\w{5})\\]");
		Matcher m = encrypt.matcher("aaaaa-bbb-z-y-x-123[abxyz]");
		assertTrue(m.matches());
		assertEquals("aaaaa-bbb-z-y-x-", m.group(1));
		assertEquals("123", m.group(2));
		assertEquals("abxyz", m.group(3));
	}

	@Test
	public void test1() throws Exception {
		List<String> input = Arrays.asList(new String[]{
			"aaaaa-bbb-z-y-x-123[abxyz]",
			"a-b-c-d-e-f-g-h-987[abcde]",
			"not-a-real-room-404[oarel]",
			"totally-real-room-200[decoy]"
		});
		assertEquals(1514, sto.sumOfSectorIds(input.iterator()));
	}

	@Test
	public void test2() throws Exception {
		Scanner scanner = new Scanner(new File("resources/adventofcode/day4"));
		assertEquals(409147, sto.sumOfSectorIds(scanner));
	}

	@Test
	public void test3() throws Exception {
		List<String> input = Arrays.asList(new String[]{"qzmt-zixmtkozy-ivhz-343[zimtn]"});
		assertEquals(343, sto.sectorIdExpectedCodeStored(input.iterator(), "very encrypted name"));
	}

	@Test
	public void test4() throws Exception {
		Scanner scanner = new Scanner(new File("resources/adventofcode/day4"));
		assertEquals(991, sto.sectorIdExpectedCodeStored(scanner, "northpole"));
	}
}