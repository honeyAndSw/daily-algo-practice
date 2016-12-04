package adventofcode;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * SquaresWithThreeSidesTest
 *
 * @author naheon
 * @version 2.0.0
 * @since 2016. 12. 04.
 */
public class SquaresWithThreeSidesTest {
	SquaresWithThreeSides squares;

	@Test
	public void test0() throws Exception {
		String input = "  810  679   10";
		assertNotEquals(3, input.trim().split("\\s").length);
	}

	@Test
	public void test1() throws Exception {
		squares = new SquaresWithThreeSides();
		assertEquals(869, squares.trianglesInRow());
	}

	@Test
	public void test2() throws Exception {
		squares = new SquaresWithThreeSides();
		assertEquals(6, squares.trianglesInColumn("day3_test"));
	}

	@Test
	public void test3() throws Exception {
		squares = new SquaresWithThreeSides();
		assertEquals(1544, squares.trianglesInColumn("day3"));
	}
}