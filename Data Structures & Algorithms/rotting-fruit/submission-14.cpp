class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        //bfs O(V+E) time complexity
        const int directions[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int fresh = 0;
        queue<pair<int, int>> q; //stores rotten fruits
        int m = grid.size(), n = grid[0].size();
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (grid[i][k] == 1) {
                    fresh++;
                } else if (grid[i][k] == 2) {
                    q.push({i, k});
                }
            }
        }
        int res = 0;
        if (fresh == 0) {
            return res;
        }
        while (!q.empty()) {
            int t = q.size();
            if (fresh == 0) {
                return res;
            }
            for (int i = 0; i < t; i++) {
                auto[row, col] = q.front(); q.pop();
                for (const auto& dir : directions) {
                    int newR = row + dir[0], newC = col + dir[1];
                    if (newR < 0 || newR >= m || newC < 0 || newC >= n) {
                        continue;
                    }
                    //cout << grid[newR][newC];
                    if (grid[newR][newC] == 1) {
                        grid[newR][newC] = 2; //fresh -> rotten
                        fresh--;
                        q.push({newR, newC});
                    }

                }
            }
            res++;
        }
        return -1;
    }
};
