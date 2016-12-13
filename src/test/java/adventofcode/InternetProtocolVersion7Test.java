package adventofcode;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Scanner;

import org.junit.Test;

/**
 * InternetProtocolVersion7Test
 *
 * @author naheon
 * @version 2.0.0
 * @since 2016. 12. 13.
 */
public class InternetProtocolVersion7Test {
	InternetProtocolVersion7 ipv7 = new InternetProtocolVersion7();

	@Test
	public void test_isAbba() throws Exception {
		assertTrue(ipv7.isAbba("ioxxoj"));
		assertTrue(ipv7.isAbba("xyyx"));
		assertFalse(ipv7.isAbba("aaaa"));
		assertFalse(ipv7.isAbba(""));
		assertFalse(ipv7.isAbba("xyabcyx"));
	}

	@Test
	public void test_supportsTls() throws Exception {
		assertTrue(ipv7.supportsTls("abba[mnop]qrst"));
		assertFalse(ipv7.supportsTls("abcd[bddb]xyyx"));
		assertFalse(ipv7.supportsTls("aaaa[qwer]tyui"));
		assertTrue(ipv7.supportsTls("ioxxoj[asdfgh]zxcvbn"));
	}

	@Test
	public void test1() throws Exception {
		Scanner scanner = new Scanner(new File("resources/adventofcode/day7"));
		assertEquals(326, ipv7.countTls(scanner));
	}
}