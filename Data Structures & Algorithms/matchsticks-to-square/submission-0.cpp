class Solution {
    vector<int> dp;
    int length, n;

public:
    bool makesquare(vector<int>& matchsticks) {
        int totalLength = accumulate(matchsticks.begin(), matchsticks.end(), 0);
        if (totalLength % 4 != 0) return false;

        length = totalLength / 4;
        if (*max_element(matchsticks.begin(), matchsticks.end()) > length) {
            return false;
        }

        sort(matchsticks.rbegin(), matchsticks.rend());
        n = matchsticks.size();
        dp.resize(1 << n, INT_MIN);

        return dfs((1 << n) - 1, matchsticks) == 0;
    }

private:
    int dfs(int mask, vector<int>& matchsticks) {
        if (mask == 0) return 0;
        if (dp[mask] != INT_MIN) return dp[mask];

        for (int i = 0; i < n; i++) {
            if (mask & (1 << i)) {
                int res = dfs(mask ^ (1 << i), matchsticks);
                if (res >= 0 && res + matchsticks[i] <= length) {
                    dp[mask] = (res + matchsticks[i]) % length;
                    return dp[mask];
                }

                if (mask == (1 << n) - 1) {
                    dp[mask] = -1;
                    return -1;
                }
            }
        }

        dp[mask] = -1;
        return dp[mask];
    }
};