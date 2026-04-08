class Solution {
    public int diagonalSum(int[][] mat) {
        int c=0,j=0,i=0,n=mat.length;
        while(i<n&&j<n){
            c+=mat[i][j];
            i++;
            j++;
      }
      j=n-1;
      i=0;
      while(j>=0){
           if(i!=j){
            c+=mat[j][i];}
            j--;
            i++;
           
      }
        return c;

    }
}