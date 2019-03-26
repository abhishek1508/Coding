public class Solution {

    private static int numberOfCarrots;
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {5, 7, 8, 6, 3},
                {0, 0, 7, 0, 4},
                {4, 6, 3, 4, 9},
                {3, 1, 0, 5, 8}
        };
        int[] rowCenter = getRowMatrixCenter(input);
        int[] colCenter = getColMatrixCenter(input);
        int[] startIndex = getStartingMatrixIndex(input, rowCenter, colCenter);
        calculateCarrots(input, startIndex[0], startIndex[1]);
        System.out.println(numberOfCarrots);
    }

    private static void calculateCarrots(int[][] matrix, int i, int j) {
        // Base case
        if (i < 0 || j < 0 || i > matrix.length || j > matrix[0].length) {
            return;
        }
        if (matrix[i][j] == 0 || (i == -1 && j == -1)) {
            return;
        }

        numberOfCarrots += matrix[i][j];
        matrix[i][j] = 0;
        int[] nextIndex = returnNextMaxValueIndex(matrix, i , j);
        calculateCarrots(matrix, nextIndex[0], nextIndex[1]);
    }

    private static int[] returnNextMaxValueIndex(int[][] matrix, int i, int j) {
        int[] matrixIndex = new int[2];
        matrixIndex[0] = -1;
        matrixIndex[1] = -1;
        int max = 0;
        if (j-1 >= 0) {
            int top = matrix[i][j-1];
            if (top > max) {
                max = top;
                matrixIndex[0] = i;
                matrixIndex[1] = j-1;
            }
        }

        if (i-1 >= 0) {
            int left = matrix[i-1][j];
            if (left > max) {
                max = left;
                matrixIndex[0] = i-1;
                matrixIndex[1] = j;
            }
        }

        if (j+1 <= matrix[0].length-1) {
            int bottom = matrix[i][j+1];
            if (bottom > max) {
                max = bottom;
                matrixIndex[0] = i;
                matrixIndex[1] = j+1;
            }
        }

        if (i+1 <= matrix.length-1) {
            int right = matrix[i+1][j];
            if (right > max) {
                max = right;
                matrixIndex[0] = i+1;
                matrixIndex[1] = j;
            }
        }

        return matrixIndex;
    }

    private static int[] getStartingMatrixIndex(int[][] matrix, int[] rowCenter, int[] colCenter) {
        int max = 0;
        int[] matrixIndex = new int[2];
        int x = -1;
        int y = -1;
        for (int i = rowCenter[0]; i <= rowCenter[1]; i++) {
            for (int j = colCenter[0]; j <= colCenter[1]; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        matrixIndex[0] = x;
        matrixIndex[1] = y;
        return matrixIndex;
    }

    private static int[] getRowMatrixCenter(int[][] matrix) {
        int[] matrixIndex = new int[2];
        int numRows = matrix.length;
        int minRow = numRows/2;
        int maxRow = numRows/2;
        if (numRows % 2 != 0) {
            matrixIndex[0] = minRow;
            matrixIndex[1] = maxRow;
        } else {
            matrixIndex[0] = maxRow-1;
            matrixIndex[1] = maxRow;
        }
        return matrixIndex;
    }

    private static int[] getColMatrixCenter(int[][] matrix) {
        int[] matrixIndex = new int[2];
        int numCols = matrix[0].length;
        int minCols = numCols/2;
        int maxCols = numCols/2;
        if (numCols % 2 != 0) {
            matrixIndex[0] = minCols;
            matrixIndex[1] = maxCols;
        } else {
            matrixIndex[0] = maxCols-1;
            matrixIndex[1] = maxCols;
        }
        return matrixIndex;
    }
}
