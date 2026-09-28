class Solution {
    public int maxDepth(String s) {
      int x=0,y=0;
      for(int i=0;i<s.length();i++){
        if(s.charAt(i) == '(') x++;
        else if(s.charAt(i) == ')') x--;
        if(x>y) y=x;
      }
      return y;
    }
}