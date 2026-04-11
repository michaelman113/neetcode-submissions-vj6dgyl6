class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Build adjacency list and calculate in-degrees
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        
        // Add all courses with no prerequisites to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        
        // Process courses in topological order
        int[] result = new int[numCourses];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;
            
            for (int dependent : adj.get(course)) {
                inDegree[dependent]--;
                if (inDegree[dependent] == 0) {
                    queue.offer(dependent);
                }
            }
        }
        
        return index == numCourses ? result : new int[0];
    }
}