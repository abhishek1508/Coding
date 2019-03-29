public class LC240_Search2DMatrixII {

    public static void main(String[] args) {
        int matrix[][] = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println("Exist: "+search(matrix, 20));
    }

    private static boolean search(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int i = r-1; //1
        int j = 0;   //1
        while (i >= 0 && i < r && j >= 0 && j < c) {
            if (matrix[i][j] == target) { return true; }
            if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
