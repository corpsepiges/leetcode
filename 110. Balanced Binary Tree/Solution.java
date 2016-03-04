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
    public boolean isBalanced(TreeNode root) {
        if (root==null) {
			return true;
		}
        if (Math.abs(f(root.left)-f(root.right))>1) {
			return false;
		}
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    public int f(TreeNode root){
    	if (root==null) {
			return 0;
		}else {
			return 1+Math.max(f(root.left), f(root.right));
		}
    }
}