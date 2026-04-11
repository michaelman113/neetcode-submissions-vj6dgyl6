class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        vector<bool> visited(n, false);
        queue<int> q;
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                visited[i] = true;
                q.push(i);
                while (!q.empty()) {
                    int node = q.front(); q.pop();
                    for (int nei = 0; nei < n; nei++) {
                        if (isConnected[node][nei] && !visited[nei]) {
                            visited[nei] = true;
                            q.push(nei);
                        }
                    }
                }
            }
        }
        return res;
    }
};