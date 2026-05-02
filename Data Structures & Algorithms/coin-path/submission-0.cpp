class Solution {
public:
    vector<int> cheapestJump(vector<int>& coins, int maxJump) {
        int n = coins.size();
        vector<int> nxt(n, -1); //will store optimal path for all non -1 blocks
        vector<long> dp(n, 0); // min cost to reach the end starting from index I
        for (int i = n - 2; i >= 0; i--) {
            long minCost = INT_MAX;
            for (int j = i + 1; j <= i + maxJump && j < n; j++) {
                if (coins[j] >= 0) {
                    long cost = coins[i] + dp[j];
                    if (cost < minCost) {
                        minCost = cost;
                        nxt[i] = j; //where to jump to from there 
                    }
                }
            }
            dp[i] = minCost;
        }
        vector<int> res;
        int i;
        for (i = 0; i < n && nxt[i] > 0; i = nxt[i])
            res.push_back(i + 1);
        if (i == n - 1 && coins[i] >= 0) {
            res.push_back(n);
            return res;
        }
        return {};
    }
};


