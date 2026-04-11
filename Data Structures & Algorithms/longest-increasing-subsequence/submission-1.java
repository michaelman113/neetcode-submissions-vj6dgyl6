public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1); // Each element is at least an LIS of length 1

        // Traverse from left to right
        for (int i = 0; i < nums.length; i++) {
            // Look back at previous elements
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }
        return Arrays.stream(LIS).max().getAsInt();
    }
}
