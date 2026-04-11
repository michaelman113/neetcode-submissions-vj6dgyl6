class Solution {
    int count = 0;
    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[i].length; k++) {
                if (grid[i][k] == '1') {
                    dfs(i, k, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int k, char[][] grid) {
        if (i < 0 || i >= grid.length || k < 0 || k >= grid[i].length) {
            return;
        }
        if (grid[i][k] == '0') {
            return;
        }
        grid[i][k] = '0';
        dfs(i+1, k, grid);
        dfs(i, k+1, grid);
        dfs(i-1, k, grid);
        dfs(i, k-1, grid);
    }
}
