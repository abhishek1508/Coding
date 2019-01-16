// Check if string s1 or permutation of s1 is contained in s2

public class LC_567_OneStringOrAnagramContainedInAnother {
        public static void main(String[] args) {
            System.out.println(checkInclusion("phenylhydrazine", "acetylphenylhydrazine"));
        }

        public static boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }
            int[] s1Arr = new int[26];
            int[] s2Arr = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                s1Arr[s1.charAt(i) - 'a']++;
                s2Arr[s2.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s2.length() - s1.length(); i++) {
                if (matches(s1Arr, s2Arr)) return true;
                s2Arr[s2.charAt(i + s1.length()) - 'a']++;
                s2Arr[s2.charAt(i) - 'a']--;
            }
            return matches(s1Arr, s2Arr);
        }

        public static boolean matches(int[] s1Arr, int[] s2Arr) {
            for (int i = 0; i < s1Arr.length; i++) {
                if (s1Arr[i] != s2Arr[i]) {
                    return false;
                }
            }
            return true;
        }
}
