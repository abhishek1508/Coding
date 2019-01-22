public class CountNumberOfAnagram {
    public static void main(String[] args) {
        System.out.println(numberOfAnagramOccurence("forxxorfxdofr", "for"));
    }

    private static int numberOfAnagramOccurence(String text, String word) {
        if (text.length() < word.length()) {
            return 0;
        }
        int noOfAnagram = 0;
        int[] textArr = new int[26];
        int[] wordArr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            textArr[text.charAt(i) - 'a']++;
            wordArr[word.charAt(i) - 'a']++;
        }

        for (int i = 0; i < text.length() - word.length(); i++) {
            if (matches(textArr, wordArr)) {
                noOfAnagram++;
            }
            textArr[text.charAt(i + word.length()) - 'a']++;
            textArr[text.charAt(i) - 'a']--;
        }
        if (matches(textArr, wordArr)) {
            noOfAnagram++;
        }
        return noOfAnagram;
    }

    private static boolean matches(int[] textArr, int[] wordArr) {
        for (int i = 0; i < textArr.length; i++) {
            if (textArr[i] != wordArr[i]) {
                return false;
            }
        }
        return true;
    }
}
