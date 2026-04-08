class Solution {
    public void rotate(int[] nums, int k) {
        int l=0,r=nums.length-1;
        
          k=k%nums.length; 
          reverse(nums,l,r);
          reverse(nums,0,k-1);
          reverse(nums,k,r);
          }
     void reverse(int [] nums,int l,int r){
        while(l<=r){
            int t=nums[l];
            nums[l]=nums[r];
            nums[r]=t;
            l++;
            r--;
        }
    }
}