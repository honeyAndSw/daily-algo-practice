package codejam.qual2016;

/**
 * Created by honey.and.sw on 2017. 2. 19.
 */
public class RevengeOfThePancakes {
    public int flipToHappySide(String stack) {
        int p = stack.length() - 1;
        int flip = 0;

        while (p >= 0) {
            boolean isHappySide =
                    (stack.charAt(p) == '+' && flip % 2 == 0)
                    || (stack.charAt(p) == '-' && flip % 2 == 1);

            if (!isHappySide) flip++;
            p--;
        }

        return flip;
    }
}
