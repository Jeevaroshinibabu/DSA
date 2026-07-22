class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> s=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int v=nums[i];

            if(s.containsKey(v) && i-s.get(v)<=k){
                return true;
            }

            s.put(v,i);
        }

        return false;
    }
}