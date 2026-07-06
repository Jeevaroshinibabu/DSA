class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
     
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; 
            }
            return a[0] - b[0];
        });

        int remainingCount = 0;
        int maxEndSoFar = 0;

      
        for (int[] currentInterval : intervals) {
            int currentEnd = currentInterval[1];

            if (currentEnd > maxEndSoFar) {
                remainingCount++;
                maxEndSoFar = currentEnd; 
            }
            
        }

        return remainingCount;
    }
}
