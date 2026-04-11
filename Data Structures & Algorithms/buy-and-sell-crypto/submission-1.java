class Solution {
    public int maxProfit(int[] prices) {
        int maxDiff = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int k = i + 1; k < prices.length; k++) {
                if ((prices[i] < prices[k]) && (prices[k] - prices[i] > maxDiff)) {
                    maxDiff = prices[k] - prices[i];
                }
            }
        }
        return maxDiff;
    }
}
