public class LC_242_OneStringAnagramOfAnother {
    public static void main(String[] args) {
        String s = "asdfqwer";
        String t = "rewqsdfa";
        System.out.println(isAnagram(s, t));
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] anagramArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            anagramArr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            anagramArr[t.charAt(i) - 'a']--;
        }
        for (int anAnagramArr : anagramArr) {
            if (anAnagramArr != 0) {
                return false;
            }
        }
        return true;
    }
}
