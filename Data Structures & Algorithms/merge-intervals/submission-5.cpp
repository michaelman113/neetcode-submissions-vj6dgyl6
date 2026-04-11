class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());
        vector<vector<int>> res;
        for (int i = 0; i < intervals.size(); i++) {
            vector<int> nex = intervals[i];
            if (res.size() == 0) {
                res.push_back(nex);
                continue;
            }
            if (res.back()[1] >= nex[0]) {
                res.back()[1] = max(nex[1], res.back()[1]);
            } else {
                res.push_back(nex);
            }
        }
        return res;
    }
};
