public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1) return -1;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0},
                              {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        boolean[][] visit = new boolean[N][N];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1], length = cell[2];

            if (r == N - 1 && c == N - 1) return length;

            for (int[] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < N && nc < N &&
                    grid[nr][nc] == 0 && !visit[nr][nc]) {
                    q.offer(new int[]{nr, nc, length + 1});
                    visit[nr][nc] = true;
                }
            }
        }
        return -1;
    }
}