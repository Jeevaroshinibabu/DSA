class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==0) return -1;

        int prev2=0;
        int prev1=0;

        for(int money:nums){
            int rob=money+prev2;
            int curr=Math.max(rob,prev1);

            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}