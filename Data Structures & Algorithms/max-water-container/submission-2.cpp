class Solution {
public:
    int maxArea(vector<int>& heights) {
        int left = 0;
        int right = heights.size() - 1;
        int leftMax = heights[left];
        int rightMax = heights[right];
        int res = 0;
        while (left < right) {
            res = max(res, min(leftMax, rightMax) * (right - left));
            if (leftMax < rightMax) {
                left++;
                leftMax = max(leftMax, heights[left]);
            } else {
                right--;
                rightMax = max(rightMax, heights[right]);
            }
        }
        return res;
    }
};
