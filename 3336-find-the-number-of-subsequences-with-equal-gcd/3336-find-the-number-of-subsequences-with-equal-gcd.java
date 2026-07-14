class Solution {
    public int subsequencePairCount(int[] nums) {
        int MOD = 1_000_000_007;
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        // dp[g1][g2] stores number of pairs with GCD g1 and g2
        // State 0 represents an empty subsequence (no GCD yet)
        int[][] dp = new int[max + 1][max + 1];
        dp[0][0] = 1; // Base case: both subsequences empty

        for (int x : nums) {
            int[][] nextDp = new int[max + 1][max + 1];
            
            for (int g1 = 0; g1 <= max; g1++) {
                for (int g2 = 0; g2 <= max; g2++) {
                    if (dp[g1][g2] == 0) continue;

                  
                    nextDp[g1][g2] = (nextDp[g1][g2] + dp[g1][g2]) % MOD;

                   
                    int n1 = (g1 == 0) ? x : gcd(g1, x);
                    nextDp[n1][g2] = (nextDp[n1][g2] + dp[g1][g2]) % MOD;

                    int n2 = (g2 == 0) ? x : gcd(g2, x);
                    nextDp[g1][n2] = (nextDp[g1][n2] + dp[g1][g2]) % MOD;
                }
            }
            dp = nextDp;
        }

        
        int ans = 0;
        for (int g = 1; g <= max; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }
        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
