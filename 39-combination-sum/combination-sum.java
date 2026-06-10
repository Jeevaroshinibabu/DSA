class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> r=new ArrayList<>();
        solve(candidates,r,target,0,new ArrayList<>());
        return r;
    }
    public void solve(int[] c,List<List<Integer>> r,int k,int index,ArrayList<Integer> al){
        if(k==0){
            r.add(new ArrayList<>(al));
            return;
        }

        if(k<0||index==c.length){
            return;
        }

        al.add(c[index]);
        solve(c,r,k-c[index],index,al);
        al.remove(al.size()-1);
        solve(c,r,k,index+1,al);

    }
}