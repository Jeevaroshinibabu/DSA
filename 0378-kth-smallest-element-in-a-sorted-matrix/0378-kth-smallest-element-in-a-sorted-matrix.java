class Solution { 
    public int kthSmallest(int[][] matrix, int k) { 
        int n = matrix.length; 
        int low = matrix[0][0]; 
        int high = matrix[n-1][n-1]; 
        
        while(low < high) { 
            int mid = low + (high - low) / 2; 
            int count = lessEqual(matrix, mid); 
            
            if(count < k) { 
                low = mid + 1; 
            } else { 
                high = mid; 
            } 
        } 
        return low; 
    } 
    
    public int lessEqual(int[][] matrix, int target) { 
        int count = 0;
        int len = matrix.length;
        int i = 0;            
        int j = len - 1; 
        
        while(i < len && j >= 0) { 
            if(matrix[i][j] > target) { 
                j--;          
            } else { 
                count += j + 1; 
                i++;          
            } 
        } 
        return count; 
    } 
}
