class Solution {
    public int numEnclaves(int[][] grid) {
        int c=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int j=0;j<m;j++){
            if(grid[0][j]==1){
                dfs(grid,0,j,n,m);
            }
            if(grid[n-1][j]==1){
                dfs(grid,n-1,j,n,m);
            }
        }

        for(int i=0;i<n;i++){
            if(grid[i][0]==1){
                dfs(grid,i,0,n,m);
            }
            if(grid[i][m-1]==1){
                dfs(grid,i,m-1,n,m);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    c++;
                }
            }
        }
        return c;
    }
    public void dfs(int[][] g,int r,int c,int n,int m){
        if(r<0||c<0||r>=n||c>=m||g[r][c]==0){
            return ;
        }
        g[r][c]=0;
        dfs(g,r,c-1,n,m);
        dfs(g,r,c+1,n,m);
        dfs(g,r-1,c,n,m);
        dfs(g,r+1,c,n,m);
    }
}