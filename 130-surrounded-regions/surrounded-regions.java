class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                bfs(board,i,0);
            }
            if(board[i][n-1]=='O'){
                bfs(board,i,n-1);
            }
        }
        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                bfs(board,0,i);
            }
            if(board[m-1][i]=='O'){
                bfs(board,m-1,i);
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
    public void bfs(char[][] b ,int r,int c){
        int m=b.length;
        int n=b[0].length;
        Queue<int[]> q=new LinkedList<>();
        
        b[r][c]='#';
        q.offer(new int[]{r,c});

        int[] drow={-1,1,0,0};
        int[] dcol={0,0,-1,1};
        while(!q.isEmpty()){
            int[] ce=q.poll();
            int cr=ce[0];
            int cc=ce[1];

            for(int i=0;i<4;i++){
                int nr=cr+drow[i];
                int nc=cc+dcol[i];

                if(nr>=0&&nr<m&&nc>=0&&nc<n&& b[nr][nc]=='O'){
                    b[nr][nc]='#';
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
    }
