package codejam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by honey.and.sw on 2017. 2. 19.
 */
public class CodeJamRwHelper {
    private static String resourcePrefix = "resources/codejam/";

    private String input;
    private String output;

    public CodeJamRwHelper(String input, String output) {
        this.input = input;
        this.output = output;
    }

    public Scanner inputScanner() throws FileNotFoundException {
        return new Scanner(new FileReader(resourcePrefix + input));
    }

    public PrintStream outputStream() throws FileNotFoundException {
        return new PrintStream(resourcePrefix + output);
    }

    public PrintStream sysout() {
        return System.out;
    }
}
