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
	public void test_isAbba1() throws Exception {
		assertTrue(ipv7.isAbba("ioxxoj"));
		assertTrue(ipv7.isAbba("xyyx"));
		assertFalse(ipv7.isAbba("aaaa"));
		assertFalse(ipv7.isAbba(""));
		assertFalse(ipv7.isAbba("xyabcyx"));
	}

	@Test
	public void test_supportsTls1() throws Exception {
		assertTrue(ipv7.supportsTls("abba[mnop]qrst"));
		assertFalse(ipv7.supportsTls("abcd[bddb]xyyx"));
		assertFalse(ipv7.supportsTls("aaaa[qwer]tyui"));
		assertTrue(ipv7.supportsTls("ioxxoj[asdfgh]zxcvbn"));
		assertTrue(ipv7.supportsTls("xxxxabbayyyy[mnop]xxxxyyyy[mnop]xxxxyyyy"));
		assertFalse(ipv7.supportsTls("xxxxabbayyyy[abba]qrst"));
		assertFalse(ipv7.supportsTls("ab[abcd]ba"));
		assertFalse(ipv7.supportsTls("aaaa[qwer]tyui"));
	}

	@Test
	public void test_supportsTls2() throws Exception {
		assertTrue(ipv7.supportsTls("abba[mnop]qrst"));
		assertFalse(ipv7.supportsTls("abcd[bddb]xyyx"));
		assertFalse(ipv7.supportsTls("aaaa[qwer]tyui"));
		assertTrue(ipv7.supportsTls("ioxxoj[asdfgh]zxcvbn"));
	}

	@Test
	public void test1() throws Exception {
		Scanner scanner = new Scanner(new File("resources/adventofcode/day7"));
		System.out.println(ipv7.countTls(scanner));
		scanner.close();
	}
}