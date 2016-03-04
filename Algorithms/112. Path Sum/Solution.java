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
    public boolean hasPathSum(TreeNode root, int sum) {
    	if (root==null) {
    		return false;
		}
    	boolean flag1=false;
    	if (root.val==sum&&root.left==null&&root.right==null) {
			return true;
		}
    	if (root.left!=null) {
			flag1=hasPathSum(root.left, sum-root.val);
		}
    	if (flag1) {
			return true;
		}
    	if (root.right!=null) {
    		return hasPathSum(root.right, sum-root.val);
		}
    	return false;
    }
}