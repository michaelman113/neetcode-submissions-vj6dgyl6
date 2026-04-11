public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Step 1: prices[i] = min cost found so far to reach node i
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0; // Cost to reach source is 0

        // Step 2: Build adjacency list: adj[u] = { (v, cost) } for each flight u → v
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (var flight : flights) {
            adj[flight[0]].add(new int[] { flight[1], flight[2] });
        }

        // Step 3: BFS queue with each state: {cost so far, node, number of stops used}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, src, 0 });

        // Step 4: BFS traversal (with stop count limited to k)
        while (!q.isEmpty()) {
            var curr = q.poll();
            int cst = curr[0];     // total cost to reach current node
            int node = curr[1];    // current node
            int stops = curr[2];   // stops taken to get here

            // If we exceed allowed stops, skip
            if (stops > k) continue;

            // Visit all neighbors
            for (var neighbor : adj[node]) {
                int nei = neighbor[0];   // neighbor city
                int w = neighbor[1];     // flight cost
                int nextCost = cst + w;

                // If the new path is cheaper, update and continue exploring
                if (nextCost < prices[nei]) {
                    prices[nei] = nextCost;
                    q.offer(new int[] { nextCost, nei, stops + 1 });
                }
            }
        }

        // If no path to dst within k stops, return -1
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
