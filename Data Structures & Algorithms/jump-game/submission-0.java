public class Solution {
    public boolean canJump(int[] nums) {
        return dfs(nums, 0);
    }
    
    private boolean dfs(int[] nums, int i) {
        if (i == nums.length - 1) {
            return true;
        }
        int end = Math.min(nums.length - 1, i + nums[i]);
        for (int j = i + 1; j <= end; j++) {
            if (dfs(nums, j)) {
                return true;
            }
        }
        return false;
    }
}