class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0);
            }
            if(board[i][n-1]=='O'){
                dfs(board,i,n-1);
            }
        }
        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                dfs(board,0,i);
            }
            if(board[m-1][i]=='O'){
                dfs(board,m-1,i);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(char[][] b,int r,int c){
        int m=b.length;
        int n=b[0].length;
        if(r<0||c<0||c>=n||r>=m||b[r][c]!='O'){
            return;
        }
        b[r][c]='#';
        dfs(b,r,c-1);
        dfs(b,r,c+1);
        dfs(b,r-1,c);
        dfs(b,r+1,c);
    }
}