class Solution {
    int sumCount = 0;
    public int findTargetSumWays(int[] nums, int target) {
        
        dfs(0, 0, nums, target);
        return sumCount;
    }

    private void dfs(int index, int sum, int[] nums, int target) {
        if (index >= nums.length) {
            return;
        }
        if (sum + nums[index] == target && sum - nums[index] == target) {
            if (index == nums.length - 1) {
                sumCount = sumCount + 2;
                return;
            }
            
        }

         if (sum + nums[index] == target || sum - nums[index] == target) {
            if (index == nums.length - 1) {
                sumCount++;
                return;
            }
            
        }

        dfs(index + 1, sum + nums[index], nums, target);
        dfs(index + 1, sum - nums[index], nums, target);
    }


}
