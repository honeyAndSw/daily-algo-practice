package adventofcode;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

/**
 * SignalsAndNoiseTest
 */
public class SignalsAndNoiseTest {
	List<String> input = Arrays.asList("eedadn", "drvtee", "eandsr", "raavrd", "atevrs", "tsrnev", "sdttsa",
			"rasrtv", "nssdts", "ntnada", "svetve", "tesnvt", "vntsnd", "vrdear", "dvrsen", "enarar");

	@Test
	public void test1() throws Exception {
		assertEquals("easter", new SignalsAndNoise().mostCommon(input.iterator()));
	}

	@Test
	public void test2() throws Exception {
		Scanner scanner = new Scanner(new File("resources/adventofcode/day6"));
		assertEquals("mshjnduc", new SignalsAndNoise().mostCommon(scanner));
	}

	@Test
	public void test3() throws Exception {
		assertEquals("advent", new SignalsAndNoise().leastCommon(input.iterator()));
	}

	@Test
	public void test4() throws Exception {
		Scanner scanner = new Scanner(new File("resources/adventofcode/day6"));
		assertEquals("apfeeebz", new SignalsAndNoise().leastCommon(scanner));
	}
}