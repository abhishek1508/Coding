public class LC821_ShortestDistanceToChar {

    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';
        shortestToChar(S,C);
    }

    private static int[] shortestToChar(String S, char C) {
        char[] word = S.toCharArray();
        int count = 0;
        for (int i = 0; i < word.length; i++) {
            if (word[i] == C) {
                count++;
            }
        }
        int[] e_Arr = new int[count+2];
        e_Arr[0] = Integer.MIN_VALUE/2;
        e_Arr[e_Arr.length-1] = Integer.MAX_VALUE;
        int j = 1;
        for (int i = 0; i < word.length; i++) {
            if (word[i] == C) {
                e_Arr[j] = i;
                j++;
            }
        }

        int k = 0;
        int[] output = new int[word.length];
        for (int i = 0; i < word.length; i++) {
            if (i > e_Arr[k] && i <= e_Arr[k+1]) {
                output[i] = Math.min((i-e_Arr[k]),(e_Arr[k+1]-i));
            }
            if (i == e_Arr[k+1]) { k++; }
        }

        return output;
    }
}
