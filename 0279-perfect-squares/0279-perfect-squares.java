class Solution {
    public int numSquares(int n) {
        int[] a=new int[n+1];
        Arrays.fill(a,Integer.MAX_VALUE);
        a[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                a[i]=Math.min(a[i],a[i-j*j]+1);
            }
        }
        return a[n];
    }
}