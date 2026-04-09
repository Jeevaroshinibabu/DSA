class Solution {
    public void moveZeroes(int[] nums) {
        int l=0,r=nums.length;
       for(int i=0;i<r;i++){
        if(nums[i]!=0){
        nums[l++]=nums[i];}
       }
       for(int i=l;i<r;i++){
        nums[i]=0;
       }
    }
}