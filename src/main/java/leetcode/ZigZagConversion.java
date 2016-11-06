package leetcode;

import java.util.Arrays;

/**
 * ZigZagConversion
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * Created by honey.and.sw on 2016. 11. 6.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        String[] rows = new String[numRows];
        Arrays.fill(rows, "");

        int row = 0;
        boolean up = true;
        for (int i = 0; i < s.length(); i++) {
            rows[row] = rows[row] + s.charAt(i);
            row = up ? Math.min(row + 1, numRows - 1) : Math.max(row - 1, 0);
            if (row == 0 || row == numRows - 1) up = !up;
        }

        StringBuilder sb = new StringBuilder();
        for (String str : rows) sb.append(str);
        return sb.toString();
    }
}
