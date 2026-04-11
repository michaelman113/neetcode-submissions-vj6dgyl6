class Solution {
     private static final int[][] directions = {{1, 0}, {-1, 0}, 
                                               {0, 1}, {0, -1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int islands = 0;
        
        int maxArea = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    int currArea = dfs(grid, r, c, 0);
                    if (currArea > maxArea) {
                        maxArea = currArea;
                    }
                }
            }
        }
        
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c, int area) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || 
        grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        area = 1;
        for (int[] dir : directions) {
            area = area + dfs(grid, r + dir[0], c + dir[1], area);
        }
        return area;
    }
}

