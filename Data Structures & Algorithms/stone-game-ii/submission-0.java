public class Solution {
    // 3D DP cache: [whose turn][start index][M value]
    // alice = 1 for Alice's turn, 0 for Bob's turn
    private int[][][] dp;

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        // Initialize memo table: dp[player][index][M]
        dp = new int[2][n][n + 1];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);  // Mark all states as uncomputed
            }
        }

        // Start the game with Alice (1), index 0, and M = 1
        return dfs(1, 0, 1, piles);
    }

    // DFS with memoization
    // alice: 1 if it's Alice's turn, 0 for Bob
    // i: current index in piles
    // M: current value of M
    private int dfs(int alice, int i, int M, int[] piles) {
        // Base case: all stones are taken
        if (i == piles.length) return 0;

        // Return cached result if computed
        if (dp[alice][i][M] != -1) return dp[alice][i][M];

        // Initialize result: Alice wants to maximize, Bob wants to minimize
        int res = alice == 1 ? 0 : Integer.MAX_VALUE;

        // Total stones taken in this move
        int total = 0;

        // Try all X where 1 ≤ X ≤ 2*M
        for (int X = 1; X <= 2 * M; X++) {
            if (i + X > piles.length) break; // Out of bounds

            total += piles[i + X - 1]; // Add the stone at the current position

            if (alice == 1) {
                // Alice chooses X to maximize her score
                res = Math.max(res, total + dfs(0, i + X, Math.max(M, X), piles));
            } else {
                // Bob chooses X to minimize Alice's future score
                res = Math.min(res, dfs(1, i + X, Math.max(M, X), piles));
            }
        }

        // Memoize and return
        dp[alice][i][M] = res;
        return res;
    }
}
