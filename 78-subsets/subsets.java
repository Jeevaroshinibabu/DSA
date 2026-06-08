class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> r=new ArrayList<>();
        sub(nums,0,new ArrayList<>(),r);
        return r;
    }
    public void sub(int[] arr ,int i,ArrayList<Integer> al,List<List<Integer>> r){
        if(i==arr.length){
            r.add(new ArrayList<>(al));
            return;
        }
        al.add(arr[i]);
        sub(arr,i+1,al,r);
        al.remove(al.size()-1);
        sub(arr,i+1,al,r);
    }
}