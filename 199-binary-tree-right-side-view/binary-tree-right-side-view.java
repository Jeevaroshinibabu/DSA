/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         thlis.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> n=new ArrayList<>();
        if(root==null){
            return n;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++ ){
                 TreeNode c=q.poll();
                 if(s-1==i){
                    n.add(c.val);
                 }
                if(c.left!=null){
                     q.add(c.left);
                 }
                if(c.right!=null){
                    q.add(c.right);
                }
            }
        }
        return n;
        
    }
}