class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        vector<vector<int>> directions = {{1,0},{0,1},{-1,0},{0,-1}};
        int count = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int k = 0; k < grid[i].size(); k++) {
                if (grid[i][k] == '1') {
                    dfs(grid, directions, i, k);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(vector<vector<char>>& grid, vector<vector<int>>& directions, int r, int c) {
        grid[r][c] = '0';
        for (const auto& dir : directions) {
            int newR = r + dir[0], newC = c + dir[1];
            if (newR < 0 || newR >= grid.size() || newC < 0 || newC >= grid[0].size()) {
                continue;
            }
            if (grid[newR][newC] == '0') {
                continue;
            }
            dfs(grid, directions, newR, newC);
        }
    }
};
