class Solution {
    public int uniquePathsWithObstacles(int[][] o) {
        int m=o.length;
        int n=o[0].length;

        int[] dp=new int [n];
        if(o[0][0]==0){
            dp[0]=1;}
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(o[i][j]==1){
                    dp[j]=0;
                }
                else if(j>0){
                    dp[j]+=dp[j-1];
                }
            }
        }
        return dp[n-1];
    }
}