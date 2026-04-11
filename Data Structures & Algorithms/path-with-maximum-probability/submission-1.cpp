class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
        // Step 1: Build the graph using an adjacency list.
        unordered_map<int, vector<pair<int, double>>> graph;
        for (int i = 0; i < edges.size(); ++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph[u].push_back({v, prob});
            graph[v].push_back({u, prob});
        }

        // Step 2: Initialize a max-heap (priority queue).
        priority_queue<pair<double, int>> maxHeap;
        maxHeap.push({1.0, start}); // Start with probability 1.0

        // Store the maximum probability found so far to reach each node.
        vector<double> maxProbs(n, 0.0);
        maxProbs[start] = 1.0;

        // Step 3: Modified Dijkstra's algorithm loop
        while (!maxHeap.empty()) {
            auto [prob, node] = maxHeap.top();
            maxHeap.pop();
            
            // If we found a better path already, skip.
            if (prob < maxProbs[node]) {
                continue;
            }
            
            // Reached the destination with the highest possible probability.
            if (node == end) {
                return prob;
            }

            // Explore neighbors
            if (graph.count(node)) {
                for (auto& neighbor : graph[node]) {
                    int nextNode = neighbor.first;
                    double edgeProb = neighbor.second;
                    double newProb = prob * edgeProb;

                    // If this path is better, update and add to the heap.
                    if (newProb > maxProbs[nextNode]) {
                        maxProbs[nextNode] = newProb;
                        maxHeap.push({newProb, nextNode});
                    }
                }
            }
        }

        // Step 4: If the end node is unreachable, return 0.
        return 0.0;
    }
};