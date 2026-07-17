class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        long[] countPairsWithGcd = new long[maxVal + 1];
        int[] freq = new int[maxVal + 1];
        for (int num : nums) {
            freq[num]++;
        }

       
        for (int g = 1; g <= maxVal; ++g) {
            long totalMultiples = 0;
            for (int mult = g; mult <= maxVal; mult += g) {
                totalMultiples += freq[mult];
            }
            countPairsWithGcd[g] = totalMultiples * (totalMultiples - 1) / 2;
        }

      
        for (int g = maxVal; g >= 1; --g) {
            for (int mult = 2 * g; mult <= maxVal; mult += g) {
                countPairsWithGcd[g] -= countPairsWithGcd[mult];
            }
        }

       
        long[] prefix = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; ++i) {
            prefix[i] = prefix[i - 1] + countPairsWithGcd[i];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            long q = queries[i];
            int left = 1, right = maxVal, res = 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (prefix[mid] > q) {
                    res = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = res;
        }

        return ans;
    }
}
