class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int n = nums.size();
        // The output vector will have n - k + 1 elements, which is the total number of windows.
        vector<int> output(n - k + 1);
        
        // A deque (double-ended queue) will store indices of elements in the current window.
        // It's maintained in a way that the indices correspond to values in decreasing order.
        // So, q.front() will always be the index of the maximum element in the window.
        deque<int> q;
        
        // 'l' is the left pointer of the window, 'r' is the right pointer.
        int l = 0, r = 0;

        // Iterate through the array with the right pointer to expand the window.
        while (r < n) {
            // --- Step 1: Maintain the monotonic property ---
            // Before adding the new element's index (r), remove any indices from the back
            // of the deque that correspond to elements smaller than nums[r].
            // Why? If nums[q.back()] < nums[r], the element at q.back() can never be the
            // maximum in any future window that also contains r, because nums[r] is larger
            // and will persist in the window longer. So, q.back() becomes irrelevant.
            while (!q.empty() && nums[q.back()] < nums[r]) {
                q.pop_back();
            }
            // Add the current element's index to the back of the deque.
            q.push_back(r);

            // --- Step 2: Remove out-of-bounds elements ---
            // If the index at the front of the deque is no longer in the current window
            // (i.e., it's to the left of our left pointer 'l'), remove it.
            if (l > q.front()) {
                q.pop_front();
            }

            // --- Step 3: Record the maximum for the window ---
            // Check if the window has reached its full size 'k'.
            // The 0-indexed 'r' plus 1 gives the count of elements processed so far.
            if ((r + 1) >= k) {
                // The index at the front of the deque (q.front()) is guaranteed to be the
                // index of the maximum element within the current window [l, r].
                output[l] = nums[q.front()];
                // Slide the window forward by incrementing the left pointer.
                l++;
            }
            // Always expand the window by moving the right pointer.
            r++;
        }

        return output;
    }
};