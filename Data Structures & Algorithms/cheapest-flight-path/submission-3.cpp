class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        int INF = 1e9;
        vector<vector<pair<int, int>>> adj(n);
        vector<vector<int>> dist(n, vector<int>(k + 5, INF));

        for (auto& flight : flights) {
            adj[flight[0]].push_back({flight[1], flight[2]});
        }

        dist[src][0] = 0;
        using T = tuple<int, int, int>;
        priority_queue<T, vector<T>, greater<T>> minHeap;
        //[cost - node - stops so far]
        minHeap.emplace(0, src, -1);

        while (!minHeap.empty()) {
            auto [cst, node, stops] = minHeap.top(); minHeap.pop();
            if (node == dst) return cst;
            if (stops == k || dist[node][stops + 1] < cst) continue;
            //if we used the max number of stops and haven't finished yet OR
            //if we already found a cheaper path to reach this same state
            for (auto& [nei, w] : adj[node]) {
                int nextCst = cst + w;
                int nextStops = stops + 1;
                if (dist[nei][nextStops + 1] > nextCst) {
                    dist[nei][nextStops + 1] = nextCst;
                    minHeap.emplace(nextCst, nei, nextStops);
                }
            }
        }
        return -1;
    }
};
