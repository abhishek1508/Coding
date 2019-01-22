import java.util.ArrayList;
import java.util.List;

public class LC_54_TraverseArrayInSpiralForm {

    public static void main(String[] args) {
        List<Integer> list = spiralArray(create2dArray());
        for (int i : list) {
            System.out.print(i+" ");
        }
    }

    private static int[][] create2dArray() {
        return new int[][]{{1,2,3},{10,11,4},{9,12,5},{8,7,6}};
    }

    private static List<Integer> spiralArray(int[][] matrix) {
        int x = 0;
        int y = 0;
        int numRows = matrix.length;
        int numColumns = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        while (x < numRows && y < numColumns) {
            for (int i = x; i < numColumns; i++) {
                list.add(matrix[x][i]);
            }
            x++;
            for (int i = x; i < numRows; i++) {
                list.add(matrix[i][numColumns-1]);
            }
            numColumns--;
            if (x < numRows) {
                for (int i = numColumns - 1; i >= y; i--) {
                    list.add(matrix[numRows - 1][i]);
                }
                numRows--;
            }
            if (y < numColumns) {
                for (int i = numRows - 1; i > y; i--) {
                    list.add(matrix[i][y]);
                }
                y++;
            }
        }
        return list;
    }








}
