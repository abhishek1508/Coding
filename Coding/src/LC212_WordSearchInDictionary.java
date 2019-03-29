import java.util.ArrayList;
import java.util.List;

public class LC212_WordSearchInDictionary {

    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        String[] words = new String[]{"oath","pea","eat","rain"};
        char[][] board = new char[][] {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        words(board, words);
        System.out.println(result);
    }

    private static void words(char[][] board, String[] words) {
        int r = board.length;
        int c = board[0].length;
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j]) { findWord(visited, board, words, i, j, ""); }
            }
        }
    }

    private static void findWord(boolean[][] visited, char[][] board, String[] words, int i, int j, String temp) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }

        else {
            visited[i][j] = true;
            temp = temp + String.valueOf(board[i][j]);
            if (isWordPresent(temp, words)) { result.add(temp); }
            findWord(visited, board, words, i + 1, j, temp);
            findWord(visited, board, words, i - 1, j, temp);
            findWord(visited, board, words, i, j + 1, temp);
            findWord(visited, board, words, i, j - 1, temp);

            visited[i][j] = false;
            temp = temp.replace(String.valueOf(temp.charAt(temp.length()-1)), "");
        }
    }

    private static boolean isWordPresent(String word, String[] words) {
        for (String w : words) {
            if (word.equalsIgnoreCase(w)) { return true; }
        }
        return false;
    }
}
