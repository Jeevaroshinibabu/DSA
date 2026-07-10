import java.util.Arrays;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int m = queries.length;
        int[] answer = new int[m];
        
        // 1. Pack values with original index positions and sort them
        Element[] elements = new Element[n];
        for (int i = 0; i < n; i++) {
            elements[i] = new Element(nums[i], i);
        }
        Arrays.sort(elements, (a, b) -> Integer.compare(a.val, b.val));
        
        // 2. Precompute 1-hop reach limits using an efficient two-pointer window
        int[] leftLimit = new int[n];
        int[] rightLimit = new int[n];
        int left = 0, right = 0;
        
        for (int i = 0; i < n; i++) {
            while (elements[i].val - elements[left].val > maxDiff) {
                left++;
            }
            while (right < n && elements[right].val - elements[i].val <= maxDiff) {
                right++;
            }
            leftLimit[i] = left;
            rightLimit[i] = right - 1;
        }
        
        // Map back original node index positions to the newly sorted array indexes
        int[] originalToSorted = new int[n];
        for (int i = 0; i < n; i++) {
            originalToSorted[elements[i].idx] = i;
        }
        
        // 3. Set up the Binary Lifting Tables (Sparse Matrix)
        int LOG = 32 - Integer.numberOfLeadingZeros(n) + 1;
        int[][] jumpMin = new int[LOG][n];
        int[][] jumpMax = new int[LOG][n];
        
        // Base case: 2^0 = 1 hop range limits
        for (int i = 0; i < n; i++) {
            jumpMin[0][i] = leftLimit[i];
            jumpMax[0][i] = rightLimit[i];
        }
        
        // Expand step capacities powers-of-two wide
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                int minL = jumpMin[k - 1][i];
                int maxR = jumpMax[k - 1][i];
                
                // Merge the maximum boundary reachable from both extremes of the prior jump window
                jumpMin[k][i] = Math.min(jumpMin[k - 1][minL], jumpMin[k - 1][maxR]);
                jumpMax[k][i] = Math.max(jumpMax[k - 1][minL], jumpMax[k - 1][maxR]);
            }
        }
        
        // 4. Resolve queries using exponential leaping blocks
        for (int i = 0; i < m; i++) {
            int startNode = originalToSorted[queries[i][0]];
            int targetNode = originalToSorted[queries[i][1]];
            
            if (startNode == targetNode) {
                answer[i] = 0;
                continue;
            }
            
            // Unreachable protection check: verify against largest global component bounds
            int absoluteMin = jumpMin[LOG - 1][startNode];
            int absoluteMax = jumpMax[LOG - 1][startNode];
            if (targetNode < absoluteMin || targetNode > absoluteMax) {
                answer[i] = -1;
                continue;
            }
            
            int currentL = startNode;
            int currentR = startNode;
            int steps = 0;
            
            // Greedily take massive steps forward if they do not overshoot our target position
            for (int k = LOG - 1; k >= 0; k--) {
                int nextL = Math.min(jumpMin[k][currentL], jumpMin[k][currentR]);
                int nextR = Math.max(jumpMax[k][currentL], jumpMax[k][currentR]);
                
                if (targetNode < nextL || targetNode > nextR) {
                    currentL = nextL;
                    currentR = nextR;
                    steps += (1 << k);
                }
            }
            
            // Add exactly 1 step to crossover into the target node's reach zone
            answer[i] = steps + 1;
        }
        
        return answer;
    }
    
    private static class Element {
        int val;
        int idx;
        
        Element(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
