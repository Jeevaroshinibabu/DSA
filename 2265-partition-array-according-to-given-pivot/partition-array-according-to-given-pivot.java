class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        Queue<Integer> a=new LinkedList<>();
        Queue<Integer> b=new LinkedList<>();
        Queue<Integer> c=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                a.add(nums[i]);
            }else if(nums[i]==pivot){
                b.add(nums[i]);
            }else{
                c.add(nums[i]);
            }
        }
        int[] r=new int[nums.length];
        int p=0;
        while(!a.isEmpty()){
            r[p]=a.poll();
            p++;
        }
         while(!b.isEmpty()){
            r[p]=b.poll();
            p++;
        }
         while(!c.isEmpty()){
            r[p]=c.poll();
            p++;
        }
        return r;
    }
}