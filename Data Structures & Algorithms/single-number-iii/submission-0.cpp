class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        unordered_map<int, int> count;
        for (int num : nums) {
            count[num]++;
        }

        vector<int> res;
        for (const auto& pair : count) {
            if (pair.second == 1) {
                res.push_back(pair.first);
            }
        }

        return res;
    }
};