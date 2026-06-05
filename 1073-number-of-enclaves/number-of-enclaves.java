import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Pair {
        int row;
        int col;
        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] v = new boolean[row][col];

        
        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 1) {
                q.offer(new Pair(0, i));
                v[0][i] = true;
            }
            if (grid[row - 1][i] == 1 && !v[row - 1][i]) { 
                q.offer(new Pair(row - 1, i));
                v[row - 1][i] = true; 
            }
        }

       
        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 1 && !v[i][0]) { 
                q.offer(new Pair(i, 0));
                v[i][0] = true;
            }
            if (grid[i][col - 1] == 1 && !v[i][col - 1]) {
                q.offer(new Pair(i, col - 1));
                v[i][col - 1] = true; 
            }
        }

        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            Pair c = q.poll(); 
            int nrow = c.row;
            int ncol = c.col;

            for (int i = 0; i < 4; i++) {
                int ro = nrow + drow[i];
                int co = ncol + dcol[i];

                if (ro >= 0 && ro < row && co >= 0 && co < col && !v[ro][co] && grid[ro][co] == 1) {
                    v[ro][co] = true;
                    q.offer(new Pair(ro, co));
                }
            }
        }

    
        int c = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !v[i][j]) {
                    c++;
                }
            }
        }
        return c;
    }
}
