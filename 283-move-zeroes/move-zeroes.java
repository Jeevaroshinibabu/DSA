class Solution {
    public void moveZeroes(int[] nums) {
        int l=0,r=nums.length;
        int [] a=new int[r];
        for(int i=0;i<r;i++){
            a[i]=0;
        }
        for(int i=0;i<r;i++){
            if(nums[i]!=0){
                a[l++]=nums[i];
            }
        }
        for(int i=0;i<r;i++){
            nums[i]=a[i];
        }
    }
}