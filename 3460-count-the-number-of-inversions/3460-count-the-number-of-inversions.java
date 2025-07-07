class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {
         int[] req = new int[n];
        Arrays.fill(req, -1);
        int maxRequirement = 0;
        for (int[] r : requirements) {
            req[r[0]] = r[1];
            maxRequirement = Math.max(maxRequirement, r[1]);
        }
        if (req[0] > 0) {
            return 0;
        }
        req[0] = 0;
        final int MOD = (int) 1e9 + 7;
        int[][] dp = new int[n][maxRequirement + 1];
        dp[0][0] = 1;
        for (int i = 1; i < n; ++i) {
            int left = 0, right = maxRequirement;
            if (req[i] >= 0) {
                left = right = req[i];
            }
            for (int j = left; j <= right; ++j) {
                for (int k = 0; k <= Math.min(i, j); ++k) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                }
            }
        }
        return dp[n - 1][req[n - 1]];
    }
}