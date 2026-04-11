class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        vector<vector<int>> directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int count = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int k = 0; k < grid[0].size(); k++) {
                if (grid[i][k] == '1') {
                    dfs(grid, i, k, directions);
                    count++;
                }
            }
        }
        return count;
        


    }

private:
    void dfs(vector<vector<char>>& grid, int r, int c, vector<vector<int>> directions) {
        grid[r][c] = 0;
        for (const auto& dir : directions) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            if (newR >= 0 && newR < grid.size() && newC >= 0 && newC < grid[0].size()) {
                if (grid[newR][newC] == '1') {
                    dfs(grid, newR, newC, directions);
                }
            }
        }
    }
};
