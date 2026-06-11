class Solution {
    public int climbStairs(int n) {
        int[] m=new int[n+1];
        return solve(m,n);
        
    }
    public int solve(int[] m,int n){
        if(n<=3){
            return n;
        }
        if(m[n]!=0){
            return m[n];
        }
        m[n]= solve(m,n-1)+solve(m,n-2);
        return m[n];
    }
}