import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int completeComponentsCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] nodeCount = new int[1];
                int[] edgeCount = new int[1];
                
                dfs(i, adj, visited, nodeCount, edgeCount);
                
                // For an undirected graph, each edge is counted twice in node degrees.
                // Thus, the sum of all degrees equals 2 * (number of edges).
                // A component is complete if E = k*(k-1)/2, which is the same as sum of degrees = k*(k-1)
                int k = nodeCount[0];
                if (edgeCount[0] == k * (k - 1)) {
                    completeComponentsCount++;
                }
            }
        }
        
        return completeComponentsCount;
    }
    
    private void dfs(int u, List<List<Integer>> adj, boolean[] visited, int[] nodeCount, int[] edgeCount) {
        visited[u] = true;
        nodeCount[0]++;
        edgeCount[0] += adj.get(u).size();
        
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited, nodeCount, edgeCount);
            }
        }
    }
}
