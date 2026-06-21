class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int n = piles.size();
        int l = 1, r = *max_element(piles.begin(), piles.end());
        int res = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canThisWork(piles, mid, h) == true) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    bool canThisWork(vector<int>& piles, int rate, int h) {
        long long totalHours = 0;
        for (int cur : piles) {
            totalHours += (cur + rate - 1LL) / rate;
        }
        return totalHours <= h;
    }
};