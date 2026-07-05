import java.util.List;

class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        int[][] dpSum = new int[n + 1][n + 1];
        int[][] dpPaths = new int[n + 1][n + 1];

      
        dpPaths[n - 1][n - 1] = 1; 

 
        for (int r = n - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
          
                if ((r == n - 1 && c == n - 1) || board.get(r).charAt(c) == 'X') {
                    continue;
                }

              
                int maxPrevScore = Math.max(dpSum[r + 1][c], Math.max(dpSum[r][c + 1], dpSum[r + 1][c + 1]));
                
                long totalPaths = 0;
                if (dpSum[r + 1][c] == maxPrevScore)     totalPaths += dpPaths[r + 1][c];
                if (dpSum[r][c + 1] == maxPrevScore)     totalPaths += dpPaths[r][c + 1];
                if (dpSum[r + 1][c + 1] == maxPrevScore) totalPaths += dpPaths[r + 1][c + 1];

               
                if (totalPaths > 0) {
                    int currentScore = (board.get(r).charAt(c) == 'E') ? 0 : (board.get(r).charAt(c) - '0');
                    dpSum[r][c] = maxPrevScore + currentScore;
                    dpPaths[r][c] = (int) (totalPaths % MOD);
                }
            }
        }

        return new int[]{dpSum[0][0], dpPaths[0][0]};
    }
}
