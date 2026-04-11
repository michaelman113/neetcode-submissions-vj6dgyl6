class Solution {
public:
    vector<vector<int>> dpT;
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        //dp[i][k] = number of unique paths from 0 to i,k on grid
        //dp[i][k] = number of unique paths from i,k to the end
        vector<vector<int>> directions = {{1, 0}, {0,1}};
        int m = obstacleGrid.size(), n = obstacleGrid[0].size();
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        dpT.resize(m, vector<int>(n, -1));
        return dp(obstacleGrid, 0, 0, directions, m, n);

    }

    int dp(vector<vector<int>>& obstacleGrid, int r, int c, vector<vector<int>>& directions, int m, int n) {
        if (r == m - 1 && c == n - 1) {
            return 1;
        }
        int numPaths = 0;
        for (const auto& dir : directions) {
            int newR = r + dir[0], newC = c + dir[1];
            if (newR < 0 || newR >= m || newC < 0 || newC >= n) {
                continue;
            }
            if (obstacleGrid[newR][newC] == 1) {
                continue;
            }
            if (dpT[newR][newC] != -1) {
                numPaths += dpT[newR][newC];
                continue;
            }
            //otherwise go through
            cout << newR << '\n';
            cout << newC << '\n';
            numPaths += dp(obstacleGrid, newR, newC, directions, m, n);
        }
        dpT[r][c] = numPaths;
        return numPaths;
        //dp[i][k] = dp[i+1][k] 
    }
};


//000
//000
//010