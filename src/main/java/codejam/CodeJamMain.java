package codejam;

import codejam.qual2016.CountingSheep;
import codejam.qual2016.RevengeOfThePancakes;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by honey.and.sw on 2017. 2. 19.
 */
public class CodeJamMain {

    public static void main(String[] args) throws FileNotFoundException {
        String prefix = "qual2016/RevengeOfThePancakes";

        CodeJamRwHelper helper = new CodeJamRwHelper(
                prefix + "_large.in",
                prefix + "_large.out");

        Scanner in = helper.inputScanner();
        PrintStream out = helper.outputStream();

		/* # of tests */
        int t = Integer.parseInt(in.nextLine());
        RevengeOfThePancakes revengePancakes = new RevengeOfThePancakes();

        for (int i = 1; i <= t; i++) {
            String problem = in.nextLine();
            int result = revengePancakes.flipToHappySide(problem);
            out.println("Case #" + i + ": " + result);
        }

        in.close();
        out.close();
    }
}
