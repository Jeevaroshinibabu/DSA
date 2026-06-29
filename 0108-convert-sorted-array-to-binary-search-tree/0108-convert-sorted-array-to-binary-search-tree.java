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
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return solve(nums,0,nums.length-1);
    }
    public static TreeNode solve(int[] n,int l,int r){
        if(l>r){
            return null;
        }

        int m=l+(r-l)/2;
        TreeNode node = new TreeNode (n[m]);

        node.left=solve(n,l,m-1);
        node.right=solve(n,m+1,r);

        return node;
    }
}