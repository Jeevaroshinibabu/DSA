class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0,r=nums.length-1,r1=-1,r2=-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==target){
                r1=m;
                r=m-1;
            }else if(nums[m]>target){
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        int le=0,ri=nums.length-1;
        while(le<=ri){
            int m=le+(ri-le)/2;
            if(nums[m]==target){
                r2=m;
                le=m+1;
            }else if(nums[m]<target){
                le=m+1;
            }
            else{
                ri=m-1;
            }
        }
       int [] a={r1,r2};
       return a;
    }
}