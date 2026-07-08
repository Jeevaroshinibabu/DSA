class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int MOD = 1000000007;
        int n = s.length();
        
    
        int[] nonZeroCount = new int[n + 1];
        long[] digitSum = new long[n + 1];
        long[] valX = new long[n + 1];
        long[] pow10 = new long[n + 1];
        
        pow10[0] = 1;
        for (int i = 0; i < n; i++) {
            pow10[i + 1] = (pow10[i] * 10) % MOD;
        }
        
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            nonZeroCount[i + 1] = nonZeroCount[i] + (d != 0 ? 1 : 0);
            digitSum[i + 1] = digitSum[i] + d;
            
            if (d != 0) {
                valX[i + 1] = (valX[i] * 10 + d) % MOD;
            } else {
                valX[i + 1] = valX[i];
            }
        }
        
        int qLen = queries.length;
        int[] ans = new int[qLen];
        
        for (int i = 0; i < qLen; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            
          
            long sum = digitSum[r + 1] - digitSum[l];
            
        
            int countNonZeroRight = nonZeroCount[r + 1];
            int countNonZeroLeft = nonZeroCount[l];
            int diff = countNonZeroRight - countNonZeroLeft;
            
            long x;
            if (diff == 0) {
                x = 0;
            } else {
                long leftVal = (valX[l] * pow10[diff]) % MOD;
                x = (valX[r + 1] - leftVal + MOD) % MOD;
            }
            
            ans[i] = (int) ((x * sum) % MOD);
        }
        
        return ans;
    }
}
