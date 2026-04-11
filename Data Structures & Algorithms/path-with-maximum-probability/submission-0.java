class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Step 1: Build the graph using an adjacency list.
        // Each entry maps a node to its list of neighbors and the associated edge success probability.
        Map<Integer, List<double[]>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            double prob = succProb[i];
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(new double[]{b, prob});
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(new double[]{a, prob});
        }

        // Step 2: Initialize a max-heap (priority queue sorted by max probability first).
        // Each element is an array: [current_probability, current_node]
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        maxHeap.offer(new double[]{1.0, start});  // Start from 'start' node with probability 1.0

        // Step 3: Track visited nodes to avoid revisiting and cycles.
        boolean[] visited = new boolean[n];

        // Step 4: Modified Dijkstra's algorithm loop
        while (!maxHeap.isEmpty()) {
            double[] curr = maxHeap.poll();    // Node with highest current probability
            double prob = curr[0];
            int node = (int) curr[1];

            // If we've reached the end node, return the probability
            if (node == end) return prob;

            // Skip if already visited
            if (visited[node]) continue;
            visited[node] = true;

            // Explore neighbors of the current node
            if (graph.containsKey(node)) {
                for (double[] neighbor : graph.get(node)) {
                    int nextNode = (int) neighbor[0];
                    double edgeProb = neighbor[1];

                    // Only consider unvisited neighbors
                    if (!visited[nextNode]) {
                        // Push the new probability (current * edge) and the next node to the heap
                        maxHeap.offer(new double[]{prob * edgeProb, nextNode});
                    }
                }
            }
        }

        // Step 5: If end node is unreachable, return 0.0
        return 0.0;
    }
}