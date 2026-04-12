class Solution {
public:
    int treeDiameter(vector<vector<int>>& edges) {
        int res = 0;
        int n = edges.size() + 1;
        vector<vector<int>> adj(n);
        for (auto& edge : edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }
        vector<int> visited(n, 0);
        pair<int, int> furthest1 = bfs(0, n, adj);
        pair<int, int> furthest2 = bfs(furthest1.first, n, adj);
        res = furthest2.second;
        return res;
    }
    pair<int, int> bfs(int startNode, int n, const vector<vector<int>>& adj) {
        vector<int> dist(n, -1);
        queue<int> q;
        q.push(startNode);
        dist[startNode] = 0;
        int furthestNode = startNode;

        while (!q.empty()) {
            int u = q.front(); q.pop();
            if (dist[u] > dist[furthestNode]) furthestNode = u;
            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.push(v);
                }
            }
        }
        return {furthestNode, dist[furthestNode]};
    }
};
