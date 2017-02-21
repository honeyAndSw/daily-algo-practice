package codejam.qual2016;

import static org.junit.Assert.*;

import java.io.PrintStream;

import org.junit.Test;

/**
 * CoinJamTest
 *
 * @author naheon
 * @since 2017. 02. 21.
 */
public class CoinJamTest {
	CoinJam cj = new CoinJam();

	@Test
	public void test1() throws Exception {
		PrintStream ps = System.out;
		cj.getCoinJam(6, 3, ps);
	}
}