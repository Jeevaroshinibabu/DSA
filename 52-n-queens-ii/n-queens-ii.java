class Solution {
    public int totalNQueens(int n) {
        ArrayList<List<String>> al=new ArrayList<>();
        char[][] q=new char[n][n];
        for(int i=0;i<q.length;i++){
            q[i][i]='.';
        }
        solveUntil(q,al,0);
        return al.size();
    }

    public boolean isValid(char[][] q,int r,int c){

        for(int i=c-1;i>=0;i--){
            if(q[r][i]=='Q'){
                return false;
            }
        }

        for(int i=r-1,j=c-1;i>=0&&j>=0;i--,j--){
            if(q[i][j]=='Q'){
                return false;
            }
        }

         for(int i=r+1,j=c-1;i<q.length&&j>=0;i++,j--){
            if(q[i][j]=='Q'){
                return false;
            }
        }
        
        return true;
    }

    public void solveUntil(char[][] q,ArrayList<List<String>> al,int index){
        if(index==q.length){
            ArrayList<String> t=new ArrayList<>();
            for(int i=0;i<q.length;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<q.length;j++){
                    sb.append(q[i][j]);
                }
                t.add(sb.toString());
            }
            al.add(t);
            return;
        }
        for(int i=0;i<q.length;i++){
            if(isValid(q,i,index)){
                q[i][index]='Q';
                solveUntil(q,al,index+1);
                q[i][index]='.';
            }
        }
    }
}