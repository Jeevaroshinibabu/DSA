class Solution {
    public boolean judgeCircle(String moves) {
        int x=0;
        int y=0;
        for(char m : moves.toCharArray()){
            if(m=='L') x--;
            else if(m=='R')x++;
            else if(m=='U') y++;
            else y--;
        }
        
        return x==0&&y==0;

    }
}