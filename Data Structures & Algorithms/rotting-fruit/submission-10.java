class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[0].length; k++) {
                if (grid[i][k] == 1) {
                    fresh++;
                }
                if (grid[i][k] == 2) {
                    q.add(new int[]{i, k});
                }
            }
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int time = 0;
        while (!q.isEmpty()) {
            if (fresh == 0) {
                break;
            }
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for (int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length) {
                        if (grid[newR][newC] == 1) {
                            grid[newR][newC] = 2;
                            fresh--;
                            q.add(new int[]{newR, newC});
                        } 
                    }
                }
            }
            time++;
        }


        return (fresh == 0) ? time : -1;
    }
}
