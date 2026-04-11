class Solution {
    public int minDistance(String word1, String word2) {
        //dp[i][k] min operations needed to substring word1 [:i] to substring word2 [:k]
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int k = 0; k < dp.length; k++) {
            dp[k][0] = k;
        }
        System.out.println(dp.length);
        System.out.println(dp[0].length);
        for (int j = 1; j < dp.length; j++) {
            for (int l = 1; l < dp[0].length; l++) {
                if (word1.charAt(j - 1) == word2.charAt(l - 1)) {
                    dp[j][l] = dp[j-1][l-1];
                } else {
                    int transition = Math.min(dp[j-1][l], dp[j][l-1]);
                    dp[j][l] = 1 + Math.min(dp[j-1][l-1], transition);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}