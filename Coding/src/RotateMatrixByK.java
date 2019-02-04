public class RotateMatrixByK {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        //int[][] matrix = {{1, 2, 3}, {4, 5, 6,}, {7, 8, 9}};
        //int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        rotateMatrix(matrix, 1);
        print(matrix, matrix.length, matrix[0].length);
    }

    private static void print(int[][] matrix, int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }

    private static void rotateMatrix(int[][] matrix, int k) {

        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        int end = 0;

        while (start < rows && end < columns) {
            int topLeft = matrix[start][end];
            int topRight = matrix[end][columns - 1];
            int bottomLeft = matrix[rows - 1][start];
            int bottomRight = matrix[rows - 1][columns - 1];
            for (int i = columns - 1; i > end; i--) {
                int prev = matrix[start][i-1];
                matrix[start][i] = prev;
            }
            start++;

            for (int i = rows - 1; i > start; i--) {
                int prev = matrix[i - 1][columns - 1];
                matrix[i][columns - 1] = prev;
            }
            if (rows - 1 >= start) {
                matrix[start][columns - 1] = topRight;
            }
            columns--;


            for (int i = end + 1; i <= columns; i++) {
                int curr = matrix[rows - 1][i];
                matrix[rows - 1][i - 1] = curr;
            }
            if (end + 1 <= columns) {
                matrix[rows - 1][columns - 1] = bottomRight;
            }
            rows--;

            for (int i = end + 1; i <= rows; i++) {
                int curr = matrix[i][end];
                matrix[i-1][end] = curr;
            }
            if (end + 1 <= rows) {
                matrix[rows - 1][end] = bottomLeft;
            }
            end++;
        }
    }
}
