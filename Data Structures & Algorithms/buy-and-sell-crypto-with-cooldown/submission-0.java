public class Solution {
    public int maxProfit(int[] prices) {
        
        return dfs(0, true, prices);
    }
    
    private int dfs(int i, boolean buying, int[] prices) {
        if (i >= prices.length) {
            return 0;
        }

        //Waiting then buying the next day
        int cooldown = dfs(i + 1, buying, prices);
        if (buying) {
            int buy = dfs(i + 1, false, prices) - prices[i];
            return Math.max(buy, cooldown); // max profit with either buying or cooling down
        } else {
            //Cooldown integrated after selling
            int sell = dfs(i + 2, true, prices) + prices[i];
            return Math.max(sell, cooldown); // max profit with either selling or cooldown
        }
    }
}