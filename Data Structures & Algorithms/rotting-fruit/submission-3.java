public class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>(); //Queue of Rotten Oranges
        int fresh = 0;
        int time = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                // Counts the number of fresh fruit.
                if (grid[r][c] == 1) { //Increments Fresh Fruit
                    fresh++;
                }
                if (grid[r][c] == 2) { //Adds Rotten Oranges To Queue
                    q.offer(new int[]{r, c});
                }
            }
        }
        // BFS begins.
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // Iterate until no fresh fruits remain or if this is impossible.
        while (fresh > 0 && !q.isEmpty()) { 
            int length = q.size();
            for (int i = 0; i < length; i++) {
                // Get coordinates of current rotten orange.
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for (int[] dir : directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if (row >= 0 && row < grid.length && 
                        col >= 0 && col < grid[0].length &&
                        grid[row][col] == 1) { //Rotten any adjacent oranges.
                        grid[row][col] = 2;
                        // Add the new rotten orange to the queue.
                        q.offer(new int[]{row, col});
                        // Since it's no longer fresh, decrement the count.
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
