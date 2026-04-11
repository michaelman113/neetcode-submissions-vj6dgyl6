class Solution {
    int max = Integer.MIN_VALUE;
    int test = 0;
    public int longestIncreasingPath(int[][] matrix) {
        boolean[][] memo = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[0].length; k++) {
                boolean[][] newMemo = new boolean[matrix.length][matrix[0].length];
                memo = newMemo;
                dfs(matrix, memo, i, k, 1);
            }
        }
        return max;
    }

    private void dfs(int[][] matrix, boolean[][] memo, int row, int col, int length)  {
        memo[row][col] = true;
        if (length > max) {
            max = Math.max(max, length);
        }
        int[][] directions = {{1, 0}, {0, 1},{-1, 0},{0, -1}};
        for (int[] dir : directions) {
            int newR = row + dir[0];
            int newC = col + dir[1];
            if (newR >= 0 && newR < matrix.length && newC >= 0 && newC < matrix[0].length) {
                if (matrix[newR][newC] > matrix[row][col]) {
                    if (newR >= 0) {
                        System.out.print(matrix[row][col]);
                        System.out.print(matrix[newR][newC] + "      ");
                        System.out.println(length + 1);
                        dfs(matrix, memo, newR, newC, length + 1);
                    }
                }
            }
        }
    }
}
