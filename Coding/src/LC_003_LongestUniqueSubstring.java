import java.util.HashSet;
import java.util.Set;

public class LC_003_LongestUniqueSubstring {

    public static void main(String[] args) {
        System.out.println(longestUniqueSubstring("abcabcdebb"));
    }

    private static String longestUniqueSubstring(String str) {
        Set<Character> set = new HashSet<>();
        String longestSubstring = "";
        int ans = 0;
        int i = 0; int j = 0; int len = str.length() - 1;
        while(i < len && j < len) {
            if (!set.contains(str.charAt(j))) {
                set.add(str.charAt(j++));
                ans = Math.max(ans, j-i);
            } else {
                if (ans > longestSubstring.length()) {
                    longestSubstring = str.substring(i, j);
                }
                set.remove(str.charAt(i++));
            }
        }
        // Comment line 20-22 and return ans if the problem asks to return the length of longest unique substring
        return longestSubstring;
    }
}
