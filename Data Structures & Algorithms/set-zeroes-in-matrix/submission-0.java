public class Solution {
    public void setZeroes(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int[][] mark = new int[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            System.arraycopy(matrix[r], 0, mark[r], 0, COLS);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (matrix[r][c] == 0) {
                    for (int col = 0; col < COLS; col++) {
                        mark[r][col] = 0;
                    }
                    for (int row = 0; row < ROWS; row++) {
                        mark[row][c] = 0;
                    }
                }
            }
        }

        for (int r = 0; r < ROWS; r++) {
            System.arraycopy(mark[r], 0, matrix[r], 0, COLS);
        }
    }
}