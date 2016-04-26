/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int left=-1;
        if(root.left!=null){
           left=minDepth(root.left)+1;
        }
        int right=-1;
        if(root.right!=null){
           right=minDepth(root.right)+1;
        }
        if(left==-1){
            return right;
        }
        if(right==-1){
            return left;
        }
    
        
        return Math.min(left, right);
    }
}