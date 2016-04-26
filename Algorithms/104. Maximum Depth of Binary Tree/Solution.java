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
    public int maxDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int left=-1;
        if(root.left!=null){
           left=maxDepth(root.left)+1;
        }
        int right=-1;
        if(root.right!=null){
           right=maxDepth(root.right)+1;
        }
        if(left==-1){
            return right;
        }
        if(right==-1){
            return left;
        }
    
        
        return Math.max(left, right);
    }
}