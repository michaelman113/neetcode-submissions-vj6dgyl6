class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int k = i; k < nums.length; k++) {
                sum += nums[k];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
