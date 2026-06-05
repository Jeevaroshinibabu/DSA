class Solution {
    public int numEnclaves(int[][] grid) {
        int c=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int j=0;j<m;j++){
            if(grid[0][j]==1){
                dfs(grid,0,j);
            }
            if(grid[n-1][j]==1){
                dfs(grid,n-1,j);
            }
        }

        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==1){
                dfs(grid,i,0);
            }
            if(grid[i][grid[0].length-1]==1){
                dfs(grid,i,grid[0].length-1);
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    c++;
                }
            }
        }
        return c;
    }
    public void dfs(int[][] g,int r,int c){
        if(r<0||c<0||r>=g.length||c>=g[0].length||g[r][c]==0){
            return ;
        }
        g[r][c]=0;
        dfs(g,r,c-1);
        dfs(g,r,c+1);
        dfs(g,r-1,c);
        dfs(g,r+1,c);
    }
}