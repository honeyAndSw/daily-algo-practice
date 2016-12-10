package adventofcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * NoTimeForATexicabTest
 *
 * @author naheon
 * @version 2.0.0
 * @since 2016. 12. 02.
 */
public class NoTimeForATexicabTest {
	NoTimeForATaxicab cab;
	String[] input = new String[] {"L5","R1","L5","L1","R5","R1","R1","L4","L1","L3","R2","R4","L4","L1","L1","R2","R4","R3","L1","R4","L4","L5","L4","R4","L5","R1","R5","L2","R1","R3","L2","L4","L4","R1","L192","R5","R1","R4","L5","L4","R5","L1","L1","R48","R5","R5","L2","R4","R4","R1","R3","L1","L4","L5","R1","L4","L2","L5","R5","L2","R74","R4","L1","R188","R5","L4","L2","R5","R2","L4","R4","R3","R3","R2","R1","L3","L2","L5","L5","L2","L1","R1","R5","R4","L3","R5","L1","L3","R4","L1","L3","L2","R1","R3","R2","R5","L3","L1","L1","R5","L4","L5","R5","R2","L5","R2","L1","L5","L3","L5","L5","L1","R1","L4","L3","L1","R2","R5","L1","L3","R4","R5","L4","L1","R5","L1","R5","R5","R5","R2","R1","R2","L5","L5","L5","R4","L5","L4","L4","R5","L2","R1","R5","L1","L5","R4","L3","R4","L2","R3","R3","R3","L2","L2","L2","L1","L4","R3","L4","L2","R2","R5","L1","R2"};

	@Before
	public void setUp() throws Exception {
		cab = new NoTimeForATaxicab();
	}

	@Test
	public void test1() throws Exception {
		assertEquals(5, cab.blocksToHq(new String[]{"R2", "L3"}));
		assertEquals(2, cab.blocksToHq(new String[]{"R2", "R2", "R2"}));
		assertEquals(12, cab.blocksToHq(new String[]{"R5", "L5", "R5", "R3"}));
	}

	@Test
	public void test2() throws Exception {
		assertEquals(226, cab.blocksToHq(input));
	}

	@Test
	public void test3() throws Exception {
		assertEquals(0, cab.blocksToHq(new String[]{"R5", "R5", "R5", "R5"}));
		assertEquals(192, cab.blocksToHq(new String[]{"L192"}));
	}

	@Test
	public void test4() throws Exception {
		assertEquals(4, cab.blocksToVisitTwice(new String[]{"R8", "R4", "R4", "R8"}));
	}

	@Test
	public void test5() throws Exception {
		System.out.println(cab.blocksToVisitTwice(input));

	}
}