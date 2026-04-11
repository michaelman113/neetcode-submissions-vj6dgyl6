class Solution {
public:
    string predictPartyVictory(string senate) {
        queue<int> R, D;
        int n = senate.size();

        for (int i = 0; i < n; i++) {
            if (senate[i] == 'R') {
                R.push(i);
            } else {
                D.push(i);
            }
        }

        while (!R.empty() && !D.empty()) {
            int rTurn = R.front(); R.pop();
            int dTurn = D.front(); D.pop();

            if (rTurn < dTurn) {
                R.push(rTurn + n);
            } else {
                D.push(dTurn + n);
            }
        }

        return R.empty() ? "Dire" : "Radiant";
    }
};