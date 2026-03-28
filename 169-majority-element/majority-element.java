class Solution {
    public int majorityElement(int[] nums) {
       HashMap<Integer,Integer> h=new HashMap<>();
       for (int i=0;i<nums.length;i++){
        h.put(nums[i],h.getOrDefault(nums[i],0)+1);
       }
       for(Map.Entry<Integer,Integer> e:h.entrySet()){
        if (e.getValue()>(nums.length/2)){
            return e.getKey();
        }
       }
       return 0;
    }
}