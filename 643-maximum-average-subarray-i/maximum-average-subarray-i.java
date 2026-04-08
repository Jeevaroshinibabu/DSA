class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double s=0;
        for(int i=0;i<k;i++){
            s+=nums[i];
        }
        double m=s/k;
        for(int i=k;i<nums.length;i++){
            s+=nums[i]-nums[i-k];
            double r=s/k;
            m=Math.max(m,r);
        }
       return m;
    }
}