class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=0) return 0;
        int l=0,p=1;
        int m=0;
        for(int i=0;i<nums.length;i++){
            p*=nums[i];
            while(p>=k&&l<=i){
                p/=nums[l];
                l++;
            }
          m+=(i-l+1);
        }
        return m;
    }
}