class Solution {
public:
    string stoneGameIII(vector<int>& stoneValue) {
        n = stoneValue.size();
        dp.assign(n, INT_MIN);

        int result = dfs(0, stoneValue);
        if (result == 0) return "Tie";
        return result > 0 ? "Alice" : "Bob";
    }

private:
    vector<int> dp;
    int n;

    int dfs(int i, vector<int>& stoneValue) {
        if (i >= n) return 0;
        if (dp[i] != INT_MIN) return dp[i];

        int res = INT_MIN, total = 0;
        for (int j = i; j < min(i + 3, n); j++) {
            total += stoneValue[j];
            res = max(res, total - dfs(j + 1, stoneValue));
        }

        dp[i] = res;
        return res;
    }
};