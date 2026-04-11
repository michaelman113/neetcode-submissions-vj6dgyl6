class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int res = 0, curSum = 0;
        unordered_map<int, int> prefixSums;
        prefixSums[0] = 1;

        for (int num : nums) {
            curSum += num;
            int diff = curSum - k;
            res += prefixSums[diff];
            prefixSums[curSum]++;
        }
        //[(0,1)]
        //[(0,1) (2,1)] 1
        //[(0,1) (2,1) (1,1)] 1
        //[(0,1) (2,2) (1,1)] 2
        //[(0,1) (2,2) (1,1) (4,1)] 4

        return res;
    }
};
