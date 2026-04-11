class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left < right) {
            if (height[left] < height[right]) {
                res += leftMax - height[left];
                left++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                res += rightMax - height[right];
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return res;
    }
}
