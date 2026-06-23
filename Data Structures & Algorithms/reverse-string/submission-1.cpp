class Solution {
public:
    void reverseString(vector<char>& s) {
        int n = s.size();
        int l = 0, r = n - 1;
        while (l <= r) {
            int temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
        
    }
};