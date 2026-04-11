class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        vector<char> res = rec(a, b, c, 'a', 'b', 'c');
        return string(res.begin(), res.end());
    }

private:
    vector<char> rec(int max1, int max2, int max3, char char1, char char2, char char3) {
        if (max1 < max2) {
            return rec(max2, max1, max3, char2, char1, char3);
        }
        if (max2 < max3) {
            return rec(max1, max3, max2, char1, char3, char2);
        }
        if (max2 == 0) {
            vector<char> result(min(2, max1), char1);
            return result;
        }

        int use1 = min(2, max1);
        int use2 = (max1 - use1 >= max2) ? 1 : 0;

        vector<char> res(use1, char1);
        res.insert(res.end(), use2, char2);

        vector<char> rest = rec(max1 - use1, max2 - use2, max3, char1, char2, char3);
        res.insert(res.end(), rest.begin(), rest.end());

        return res;
    }
};