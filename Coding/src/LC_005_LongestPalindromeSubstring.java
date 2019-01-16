import java.util.HashSet;
import java.util.Set;

public class LC_005_LongestPalindromeSubstring {

    public static void main(String[] args) {
        System.out.println(longest("asdfwerewfdzxcv"));
    }

    private static String longest(String s) {
        int length = s.length();
        int low, high;
        int start = 0;
        int maxLength = 0;
        for (int i = 1; i<length; i++) {
            //Even length
            low = i-1;
            high = i;
            while (low >= 0 && high < length && s.charAt(low) == s.charAt(high)) {
                if (maxLength <= high - low + 1) {
                    start = low;
                    maxLength =  high - low + 1;
                }
                low--;
                high++;
            }

            // Odd length
            low = i-1;
            high = i+1;
            while (low >= 0 && high < length && s.charAt(low) == s.charAt(high)) {
                if (maxLength <= high - low + 1) {
                    start = low;
                    maxLength =  high - low + 1;
                }
                low--;
                high++;
            }
        }
        if (length > 1 && start == 0 && maxLength == 0) {
            return String.valueOf(s.charAt(0));
        }
        return s.substring(start, start + maxLength);
    }
}
