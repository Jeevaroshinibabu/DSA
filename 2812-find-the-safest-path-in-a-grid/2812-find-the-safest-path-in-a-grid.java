class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) return 0;

        int[][] dist = computeThiefDistances(grid, n);
        return findMaxSafenessPath(dist, n);
    }

  
    private int[][] computeThiefDistances(List<List<Integer>> grid, int n) {
        int[][] dist = new int[n][n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                } else {
                    dist[i][j] = -1; 
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] d : dirs) {
                int r = curr[0] + d[0], c = curr[1] + d[1];
                if (r >= 0 && r < n && c >= 0 && c < n && dist[r][c] == -1) {
                    dist[r][c] = dist[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{r, c});
                }
            }
        }
        return dist;
    }

    
    private int findMaxSafenessPath(int[][] dist, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        boolean[][] visited = new boolean[n][n];

        pq.offer(new int[]{dist[0][0], 0, 0});
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int safeness = curr[0], r = curr[1], c = curr[2];

            if (r == n - 1 && c == n - 1) return safeness;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    pq.offer(new int[]{Math.min(safeness, dist[nr][nc]), nr, nc});
                }
            }
        }
        return 0;
    }
}
