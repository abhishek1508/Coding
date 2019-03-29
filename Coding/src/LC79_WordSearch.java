public class LC79_WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(exist(board, "ABCCED"));
    }

    private static boolean exist(char[][] board, String word) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isWordFormed(board, word, i, j, 0)) { result = true; }
            }
        }
        return result;
    }

    private static boolean isWordFormed(char[][] board, String word, int i, int j, int k) {
        if (i < 0 || i  >= board.length || j < 0 || j >= board[0].length) { return false; }
        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            board[i][j] = '#';
            if (k == word.length()-1) { return true; }
            else if (isWordFormed(board, word, i + 1, j, k+1) ||
            isWordFormed(board, word, i - 1, j, k+1) ||
            isWordFormed(board, word, i, j + 1, k+1) ||
            isWordFormed(board, word, i, j - 1, k+1)) { return true; }
            board[i][j] = temp;
        }
        return false;
    }
}
