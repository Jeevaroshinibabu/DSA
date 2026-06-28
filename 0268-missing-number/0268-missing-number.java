class Solution {
    public int missingNumber(int[] nums) {
         int n=nums.length,s=0,s2=0;
        for(int i=0;i<n;i++){
         s+=nums[i];
            s2=n*(n+1)/2;
    
         }
        return s2-s;
    }
}