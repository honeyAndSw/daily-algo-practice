package codejam.qual2016;

import java.util.HashSet;

/**
 * Created by honey.and.sw on 2017. 2. 19.
 */
public class CountingSheep {

    public int fallAsleep(int n) {
        HashSet<Integer> history = new HashSet<>();
        int accum = 0;
        int prev = 0;

        while (history.size() < 10) {
            accum += n;
            if (prev == accum) return -1;

            char[] ch = Integer.toString(accum).toCharArray();
            for (char c : ch) {
                history.add(Integer.parseInt(c + ""));
            }

            prev = accum;
        }

        return prev;
    }
}
