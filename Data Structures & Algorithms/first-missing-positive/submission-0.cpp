class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int missing = 1;
        for (int num : nums) {
            if (num > 0 && missing == num) {
                missing++;
            }
        }
        return missing;
    }
};