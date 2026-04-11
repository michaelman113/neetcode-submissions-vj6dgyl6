class Solution {
    public int swimInWater(int[][] grid) {
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] {grid[0][0], 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0];
            int r = cur[1];
            int c = cur[2];
            if (r == m - 1 && c == n - 1) {
                return time;
            }
            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                if (newR >= 0 & newR < m && newC >= 0 && newC < n) {
                    if (visited[newR][newC] == 0) {
                        pq.add(new int[] {Math.max(time, grid[newR][newC]), newR, newC});
                        visited[newR][newC] = 1;
                    }
                }
            }
        }
        return -1;

    }
}
 