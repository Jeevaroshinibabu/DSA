class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> r=new ArrayList<>();
        solve(nums,0,r);
        return r;
    }
    public void solve(int[] nums,int index,List<List<Integer>> r){
        if(index==nums.length){
            ArrayList<Integer> al=new ArrayList<>();
            for(int n:nums){
                al.add(n);
            }
            r.add(al);
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(nums,i,index);
            solve(nums,index+1,r);
            swap(nums,i,index);
        }
    }
    public void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}