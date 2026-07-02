class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] vis = new int[m][n];
        Queue<int[]> q = new LinkedList<>(List.of(new int[]{0, 0, health - grid.get(0).get(0)}));
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], h = curr[2];
            if (h <= 0 || h <= vis[r][c]) continue;
            if (r == m - 1 && c == n - 1) return true;
            
            vis[r][c] = h;
            int[] d = {0, 1, 0, -1, 0}; 
            for (int i = 0; i < 4; i++) {
                int nr = r + d[i], nc = c + d[i + 1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    q.offer(new int[]{nr, nc, h - grid.get(nr).get(nc)});
                }
            }
        }
        return false;
    }
}