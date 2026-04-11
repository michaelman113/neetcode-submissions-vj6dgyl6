public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses]; // Array to store indegrees of each course.
        List<List<Integer>> adj = new ArrayList<>(); // Adjacency list to represent the graph.

        for (int i = 0; i < numCourses; i++) { // Initialize the adjacency list.
            adj.add(new ArrayList<>()); // Create an empty list for each course.
        }

        for (int[] pre : prerequisites) { // Process prerequisites.
            indegree[pre[1]]++; // Increment indegree of the course that has a prerequisite.
            adj.get(pre[0]).add(pre[1]); // Add an edge from pre[0] to pre[1] in the adjacency list.
        }

        Queue<Integer> q = new LinkedList<>(); // Line 12: Queue for BFS.

        for (int i = 0; i < numCourses; i++) { 
            if (indegree[i] == 0) { // If a course has no prerequisites, it can be added immediately.
                q.add(i); 
            }
        }

        int finish = 0; // Counter for finished courses.
        int[] output = new int[numCourses]; // Array to store the course order.

        while (!q.isEmpty()) { // BFS loop.
            int node = q.poll(); // Dequeue a course.
            output[numCourses - finish - 1] = node; // Add the course to the output array (in reverse order).
            finish++; // Line 25: Increment the finished courses count.

            for (int nei : adj.get(node)) { // Iterate through neighbors (courses that depend on this course).
                indegree[nei]--; // Decrement the indegree of the neighbor.
                if (indegree[nei] == 0) { // If the neighbor now has no prerequisites.
                    q.add(nei); // Add it to the queue.
                }
            }
        }

        if (finish != numCourses) { // Check for cycles (if not all courses can be finished).
            return new int[0]; // If there's a cycle, return an empty array.
        }

        return output; // Return the course order.
    }
}