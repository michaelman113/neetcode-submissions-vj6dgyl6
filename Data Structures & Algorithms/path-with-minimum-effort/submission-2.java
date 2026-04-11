class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] minDist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                minDist[i][k] = Integer.MAX_VALUE;
            }
        }
        int[][] directions = {{1,0}, {0,1}, {-1,0},{0,-1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int dist = cur[0];
            int r = cur[1];
            int c = cur[2];
            if (r == m - 1 && c == n - 1) {
                return dist;
            }
            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                if (newR >= 0 && newR < m && newC >= 0 && newC < n) {
                    if (Math.abs(heights[newR][newC] - heights[r][c]) < minDist[newR][newC]) {
                        minDist[newR][newC] = Math.abs(heights[newR][newC] - heights[r][c]);
                        pq.add(new int[]{Math.max(dist, minDist[newR][newC]), newR, newC});
                    }
                }
            }


        }
        return 0;
    }
}