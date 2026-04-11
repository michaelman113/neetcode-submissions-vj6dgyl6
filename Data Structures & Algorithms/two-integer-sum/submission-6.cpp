class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> res;
        for (int i = 0; i < nums.size(); i++) {
            if (res.count(target - nums[i])) {
                return {res[target - nums[i]], i};
            }
            res.insert({nums[i], i});
        }
        return {};
    }
};
