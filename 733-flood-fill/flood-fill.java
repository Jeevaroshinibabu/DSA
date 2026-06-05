class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        int s=image[sr][sc];
        dfs(image,sr,sc,s,color);
        return image;
    }
    public void dfs(int[][] g,int r,int c,int s,int n){
        if (r < 0 || c < 0 || r >= g.length || c >= g[0].length || g[r][c] != s) {
            return;
        }

        if(g[r][c]==s){
                g[r][c]=n;
        }
        dfs(g,r-1,c,s,n);
        dfs(g,r+1,c,s,n);
        dfs(g,r,c-1,s,n);
        dfs(g,r,c+1,s,n);

    }
}