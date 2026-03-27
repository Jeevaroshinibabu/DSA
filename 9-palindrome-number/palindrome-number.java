class Solution {
    public boolean isPalindrome(int x) {
        int t=x,r,k=0;
        while(x>0){
         r=x%10;
         k=k*10+r;
         x=x/10;
        }
        if(t==k){
            return true;
        }else{
            return false;
        }
    }
}