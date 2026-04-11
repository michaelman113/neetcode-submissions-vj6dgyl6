class Solution {
public:
    vector<vector<int>> dp;
    vector<vector<int>> costs;

    int minCost(vector<vector<int>>& costs) {
        int n = costs.size();
        this->costs = costs;
        dp.assign(n, vector<int>(4, -1));
        return dfs(0, -1);
    }

private:
    int dfs(int i, int prevColor) {
        if (i == costs.size()) {
            return 0;
        }
        if (dp[i][prevColor + 1] != -1) {
            return dp[i][prevColor + 1];
        }

        int res = INT_MAX;
        for (int c = 0; c < 3; c++) {
            if (c == prevColor) continue;
            res = min(res, costs[i][c] + dfs(i + 1, c));
        }

        return dp[i][prevColor + 1] = res;
    }
};