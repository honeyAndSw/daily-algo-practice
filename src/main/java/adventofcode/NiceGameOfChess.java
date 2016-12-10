package adventofcode;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Day 5 : How About a Nice Game of Chess
 * http://adventofcode.com/2016/day/5
 *
 * Created by honey.and.sw on 2016. 12. 10.
 */
public class NiceGameOfChess {
    MessageDigest md;

    public NiceGameOfChess() throws NoSuchAlgorithmException {
        md = MessageDigest.getInstance("MD5");
    }

    public String password(String id) {
        String pw = "";
        int idx = 0;

        while (pw.length() < 8) {
            md.update((id + idx++).getBytes());
            BigInteger number = new BigInteger(1, md.digest());
            String hash = number.toString(16);
            if (32 - hash.length() == 5) {
                pw += hash.charAt(0);
            }
        }

        return pw;
    }

    public String passwordSecondDoor(String id) {
        char[] pw = new char[]{'_','_','_','_','_','_','_','_'};
        int fillCnt = 0;
        int idx = 0;

        while (fillCnt < 8) {
            md.update((id + idx++).getBytes());
            BigInteger number = new BigInteger(1, md.digest());
            String hash = number.toString(16);
            if (32 - hash.length() == 5) {
                char pos = hash.charAt(0);
                if (pos >= '0' && pos < '8' && pw[pos - '0'] == '_') {
                    pw[pos - '0'] = hash.charAt(1);
                    fillCnt++;
                    System.out.println(Arrays.toString(pw));
                }
            }
        }

        return pw.toString();
    }
}