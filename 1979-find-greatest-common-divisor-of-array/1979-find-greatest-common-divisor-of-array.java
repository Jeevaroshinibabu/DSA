class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);

        int s=nums[0];
        int l=nums[nums.length-1];

        return gcd(s,l);
    }
    public int gcd(int l,int s){
        if(s==0){
            return l;
        }
        return gcd(s,l%s);
    }
}