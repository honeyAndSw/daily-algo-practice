package codejam.qual2016;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * CoinJam
 *
 * @author naheon
 * @since 2017. 02. 21.
 */
public class CoinJam {
	public void getCoinJam(int n, int j, PrintStream ps) {
		int between = n - 2;
		boolean[][] coinJamChecker = new boolean[9/*# of base*/][(int)Math.pow(2, between)/*# of possible coinjam*/];

		for (int b = 0; b < 9; b++) {
			int base = b + 2;
			int min = (int) Math.pow(base, n - 1) + 1;
			int max = (int) Math.pow(base, n) - 1;

			for (int c = min; c <= max; c += base) {
				int idx = (c - min) / base;
				if (idx == 16) {
					System.out.print(c);
				}
				coinJamChecker[base][idx] = isPrime(c);
			}
		}

		ps.println(Arrays.toString(coinJamChecker));
	}

	/**
	 * Got from manishpandit/Prime
	 * @param n
	 * @return
	 */
	private boolean isPrime(int n) {
		if(n <= 1) return false;
		if(n <= 3) return true;
		if(n % 2 == 0 || n % 3 == 0) return false;
		for(int i = 5; i*i <= n; i += 6) {
			if(n % i == 0 || n % (i + 2) == 0) return false;
		}
		return true;
	}
}
