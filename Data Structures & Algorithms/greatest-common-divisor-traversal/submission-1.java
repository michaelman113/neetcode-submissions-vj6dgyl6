public class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        
        // Track visited nodes in DFS
        boolean[] visit = new boolean[n];
        
        // Initialize adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph: if nums[i] and nums[j] share any factor > 1, connect them
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gcd(nums[i], nums[j]) > 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        // Perform DFS starting from node 0
        dfs(0, adj, visit);

        // After DFS, check if all nodes were visited
        for (boolean node : visit) {
            if (!node) {
                return false;  // Found an unconnected component
            }
        }
        return true;  // All nodes are connected
    }

    // Standard DFS traversal
    private void dfs(int node, List<List<Integer>> adj, boolean[] visit) {
        visit[node] = true;
        for (int nei : adj.get(node)) {
            if (!visit[nei]) {
                dfs(nei, adj, visit);
            }
        }
    }

    // Euclidean algorithm for finding GCD
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
