class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int[][] a=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[j][i]=matrix[i][j];
            }
        }
       
        for(int i=0;i<n;i++){
            for(int j=0;j<(n+1)/2;j++){
                int r=n-1;
                int t=a[i][j];
                a[i][j]=a[i][r-j];
                a[i][r-j]=t;
            }
        }
        for(int i=0;i<n;i++){
          for(int j=0;j<n;j++){
                matrix[i][j]=a[i][j];
            }
        }

    }
}