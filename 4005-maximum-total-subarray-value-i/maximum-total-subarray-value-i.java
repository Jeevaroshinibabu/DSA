class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max=nums[0];
        int min=nums[0];
        for(int x: nums){
            max=Math.max(x,max);
            min=Math.min(x,min);
        }
        return (long)k*(max-min);
    }
}