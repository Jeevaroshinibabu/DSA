class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> a=new ArrayList<>();
        ArrayList<Integer> b=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                a.add(nums[i]);
            }else{
                b.add(nums[i]);
            }
        }
        int[] c=new int[nums.length];
        int j=0,k=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                c[i]=a.get(j);
                j++;
            }else{
                c[i]=b.get(k);
                k++;
            }
        }
        return c;
    }
}