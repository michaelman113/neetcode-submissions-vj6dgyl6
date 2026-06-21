class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        int n = weights.size();
        int l = *max_element(weights.begin(), weights.end()); 
        int r = accumulate(weights.begin(), weights.end(), 0);
        int res = r;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (canThisWork(weights, mid, days)) {
                res = min(res, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    bool canThisWork(const vector<int>& piles, int capacity, int days) {
        int ships = 1, currCap = capacity;
        for (int w : piles) {
            if ((currCap - w) < 0) {
                ships++;
                if (ships > days) {
                    return false;
                }
                currCap = capacity;
            }
            currCap -= w;
        }
        return true;
    }
};