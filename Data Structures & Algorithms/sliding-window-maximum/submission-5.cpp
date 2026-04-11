class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> result;
        result.reserve(n - k + 1); // Optimization: Pre-allocate to avoid reallocations [cite: 114]
        
        deque<int> q; // Stores indices of elements in decreasing order

        for (int r = 0; r < n; ++r) {
            // 1. Maintain Monotonicity: Remove indices of smaller values from the back.
            // If nums[r] is greater, those older values can NEVER be the max again.
            while (!q.empty() && nums[q.back()] < nums[r]) {
                q.pop_back();
            }
            q.push_back(r);

            // 2. Bound Check: If the front index is outside the [r-k+1, r] window, drop it.
            if (q.front() < r - k + 1) {
                q.pop_front();
            }

            // 3. Record Max: Once the window hits size 'k', q.front() is always your max.
            if (r >= k - 1) {
                result.push_back(nums[q.front()]);
            }
        }
        return result;
    }
};