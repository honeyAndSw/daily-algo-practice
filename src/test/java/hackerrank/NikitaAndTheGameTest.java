package hackerrank;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * NikitaAndTheGameTest
 *
 * @author naheon
 * @version 2.0.0
 * @since 2016. 11. 02.
 */
public class NikitaAndTheGameTest {
	@Test
	public void test1() throws Exception {
		int result = NikitaAndTheGame.score(new int[]{4,1,0,1,1,0,1}, 0, 6);
		assertEquals(3, result);
	}
}