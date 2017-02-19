package codejam;

import codejam.qual2016.CountingSheep;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by honey.and.sw on 2017. 2. 19.
 */
public class CodeJamMain {

    public static void main(String[] args) throws FileNotFoundException {

        CodeJamRwHelper helper = new CodeJamRwHelper(
                "qual2016/CountingSheep_large.in",
                "qual2016/CountingSheep_large.out");

        Scanner in = helper.inputScanner();
        PrintStream out = helper.outputStream();

		/* # of tests */
        int t = Integer.parseInt(in.nextLine());
        CountingSheep cs = new CountingSheep();

        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int result = cs.fallAsleep(n);
            out.println("Case #" + i + ": " + (result == -1 ? "INSOMNIA" : result));
        }

        in.close();
        out.close();
    }
}
