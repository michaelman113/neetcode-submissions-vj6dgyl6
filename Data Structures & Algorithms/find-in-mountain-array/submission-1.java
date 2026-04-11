/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        // Step 1: Find peak index
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int midVal = mountainArr.get(mid);
            int midNext = mountainArr.get(mid + 1);
            if (midVal < midNext) {
                left = mid + 1; // climb up
            } else {
                right = mid; // climb down
            }
        }
        int peak = left;

        // Step 2: Binary search on ascending part [0, peak]
        left = 0;
        right = peak;
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = mountainArr.get(mid);
            if (val == target) return mid;
            if (val < target) left = mid + 1;
            else right = mid - 1;
        }

        // Step 3: Binary search on descending part [peak+1, n-1]
        left = peak + 1;
        right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = mountainArr.get(mid);
            if (val == target) return mid;
            if (val < target) right = mid - 1; // reversed logic
            else left = mid + 1;
        }

        return -1;
    }
}
