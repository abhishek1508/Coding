import java.util.ArrayList;

public class AllPermutationOfString {

    public static void main(String[] args) {
        String s1 = "abcd";
        ArrayList<String> allPermutations = new ArrayList<String>();
        permutations(s1, 0, s1.length()-1, allPermutations);
        for (String s : allPermutations) {
            System.out.println(s);
        }
    }

    private static void permutations(String s1, int l, int r, ArrayList<String> res) {
        if (l == r) {
            res.add(s1);
        } else {
            for (int i = l; i <= r; i++) {
                s1 = swap(s1, l, i);
                permutations(s1, l+1, r, res);
                s1 = swap(s1, l, i);
            }
        }
    }

    private static String swap(String s1, int x, int y) {
        char[] array = s1.toCharArray();
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
        return String.valueOf(array);
    }
}
