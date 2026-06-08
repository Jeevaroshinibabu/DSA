class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            adj.get(u).add(v);
        }

      
        int[] visited = new int[numCourses];
        Stack<Integer> stack = new Stack<>();

       
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (hasCycle(i, adj, visited, stack)) {
                    return new int[0]; 
                }
            }
        }

        
        int[] order = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()) {
            order[index++] = stack.pop();
        }
        return order;
    }

    private boolean hasCycle(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, Stack<Integer> stack) {
        visited[node] = 1; 

        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 1) {
                return true; 
            }
            if (visited[neighbor] == 0) {
                if (hasCycle(neighbor, adj, visited, stack)) {
                    return true;
                }
            }
        }

        visited[node] = 2; 
        stack.push(node);  
        return false;
    }
}
