class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int L = 0;
        int currSum = 0;
        int min = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            currSum += nums[r];
            if (currSum >= target) {
                while (currSum >= target) {
                    min = Math.min(min, r - L + 1);
                    currSum -= nums[L];
                    L++;
                }   
            }
        }
        return min != Integer.MAX_VALUE ? min : 0;
    }
}