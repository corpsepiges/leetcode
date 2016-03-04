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
    public int kthSmallest(TreeNode root, int k) {
        int left=f(root.left);
        if (k==left+1) {
			return root.val;
		}
        if (k<=left) {
			return kthSmallest(root.left,k);
		}
        return kthSmallest(root.right,k-left-1);
    }
    public int f(TreeNode root){
    	if (root!=null) {
			return 1+f(root.left)+f(root.right);
		}
    	return 0;
    }
}