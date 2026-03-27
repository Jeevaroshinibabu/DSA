class Solution {
    public int subtractProductAndSum(int n) {
        int t=1,s=0,r;
        while(n>0){
            r=n%10;
            s=s+r;
            t*=r;
            n=n/10;
        }
        return t-s;
    }
}