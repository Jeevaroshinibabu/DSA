class Solution {
    public int smallestIndex(int[] nums) {

        for(int i=0;i<nums.length;i++){
            if(getsum(nums[i])==i){
                return i;
            }
        }
        return -1;
    }
    public int getsum(int n){
        int t=0;
        while(n>0){
            int r=n%10;
            t=t+r;
            n=n/10;
        }
        return t;
    }
}