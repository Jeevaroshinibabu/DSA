import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        
       
        List<int[]>[] graph = new ArrayList[n];
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int maxWeight = 0;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new int[]{v, w});
            inDegree[v]++;
            maxWeight = Math.max(maxWeight, w);
        }

       
        List<Integer> topoOrder = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            topoOrder.add(u);
            for (int[] next : graph[u]) {
                if (--inDegree[next[0]] == 0) q.offer(next[0]);
            }
        }

        
        int left = 0, right = maxWeight, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            
            long[] dist = new long[n];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[0] = 0; 

            for (int u : topoOrder) {
                if (dist[u] == Long.MAX_VALUE || !online[u]) continue;

                for (int[] edge : graph[u]) {
                    int v = edge[0], weight = edge[1];

                    
                    if (online[v] && weight >= mid) {
                        if (dist[u] + weight < dist[v]) {
                            dist[v] = dist[u] + weight;
                        }
                    }
                }
            }

           
            if (dist[n - 1] <= k) {
                ans = mid;     
                left = mid + 1;  
            } else {
                right = mid - 1; 
            }
        }

        return ans;
    }
}
