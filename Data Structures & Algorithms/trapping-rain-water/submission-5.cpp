class Solution {
public:
    int trap(vector<int>& height) {
        int left = 0;
        int right = height.size() - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int res = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
                leftMax = max(leftMax, height[left]);
            } else {
                res += rightMax - height[right];
                right--;
                rightMax = max(rightMax, height[right]);
            }
        }
        return res;
    }
};
