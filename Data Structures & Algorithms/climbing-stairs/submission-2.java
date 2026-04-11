class Solution {
    int count = 0;
    public int climbStairs(int n) {
        dp(n, 1);
        return count;
    }

    private void dp(int n, int step) {
        if (n == 0) {
            count++;
            return;
        }
        if (n < 0) {
            return;
        }
        dp(n - 1, 1);
        dp(n - 2, 2);
    }
}
