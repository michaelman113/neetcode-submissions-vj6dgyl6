class Solution {
    public int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
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


//0 1 (add 0)
//2 1 (add 0)
//2 2 (add 0);
//2 3 (add 0);
