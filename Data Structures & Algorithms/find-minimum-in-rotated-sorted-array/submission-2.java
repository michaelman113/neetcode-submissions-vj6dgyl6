class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (nums.length == 1) {
            return nums[0];
        }
        while (start <= end) {
             if (start + 1 == end) {
                return Math.min(nums[start], nums[end]);
            }
            int mid = start + ((end - start) / 2);
            if (nums[mid] > nums[start] && nums[mid] > nums[end]) {
                start = mid;
            } else if (nums[mid] < nums[start] && nums[mid] < nums[end]) {
                end = mid;
            } else {
                end = mid;
            }
        }
        return - 1;

    }
}
