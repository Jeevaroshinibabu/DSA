class Solution {
    public int diagonalSum(int[][] mat) {
        int c=0,j=0,i=0,n=mat.length;
        while(i<n&&j<n){
            c+=mat[i][j];
            i++;
            j++;
      }
      int k=n-1;
      i=0;
      while(k>=0){
           if(i!=k){
            c+=mat[k][i];}
            k--;
            i++;
           
      }
        return c;

    }
}