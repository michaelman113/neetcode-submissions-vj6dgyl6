class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int l = 0, r = n - 1;
        int leftMax = height[l], rightMax = height[r], res = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                res += (leftMax - height[l]);
                l++;
                leftMax = max(leftMax, height[l]);
            } else {
                res += (rightMax - height[r]);
                r--;
                rightMax = max(rightMax, height[r]);
            }
        }
        return res;
    }
};
