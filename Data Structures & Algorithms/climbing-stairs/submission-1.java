class Solution {
    int[] cache;
    public int climbStairs(int n) {
     cache = new int[n]; // 6. Add memoization
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return dfs(n, 0); // 5. Choose a recursive solution.
    }

    public int dfs(int n, int i) {
        if (i >= n) { // 4. Identify base case.
            return i == n ? 1 : 0;
        }
        if (cache[i] != -1) {
            return cache[i];
        }
        cache[i] = dfs(n, i + 1) + dfs(n, i + 2);
        return cache[i];
    }
}
