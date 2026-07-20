class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length; 
        int[][] temp = new int[m][n];

       
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int newFlatIdx = (r * n + c + k) % (m * n);
                int newR = newFlatIdx / n;
                int newC = newFlatIdx % n;
                
                temp[newR][newC] = grid[r][c];
            }
        }

      
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            List<Integer> row = new ArrayList<>(); 
            for (int c = 0; c < n; c++) {
                row.add(temp[r][c]);
            }
            result.add(row); 
        }

        return result;
    }
}
