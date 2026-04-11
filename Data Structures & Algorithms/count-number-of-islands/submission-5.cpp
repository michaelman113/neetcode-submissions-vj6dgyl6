class Solution {
public:
    vector<vector<int>> directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    int numIslands(vector<vector<char>>& grid) {
        int count = 0;
        int m = grid.size();
        int n = grid[0].size();
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (grid[i][k] == '1') {
                    dfs(grid, i, k);
                    count++;
                }
            }
        }
        return count;

    }

    void dfs(vector<vector<char>>& grid, int r, int c) {
        int m = grid.size();
        int n = grid[0].size();
        grid[r][c] = '0';
        for (const auto& dir: directions) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            if (newR >= 0 && newR < m && newC >= 0 && newC < n && grid[newR][newC] == '1') {
                dfs(grid, newR, newC);
            }
        }

    }
};
