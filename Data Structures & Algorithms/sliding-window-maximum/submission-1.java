class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxArray = new int[nums.length - k + 1];
        int arrIndex = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = -1000;
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            maxArray[arrIndex] = max;
            arrIndex++;
        }
        return maxArray;
    }
}
