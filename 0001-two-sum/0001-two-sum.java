class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            hm.put(nums[i],i);
        }

        for(int i=0;i<n;i++){
            int c=target-nums[i];
            if(hm.containsKey(c)&&hm.get(c)!=i){
                return new int[]{i,hm.get(c)};
            }
        }
        return new int[]{};
    }
}