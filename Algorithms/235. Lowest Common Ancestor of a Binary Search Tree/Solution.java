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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if (root==p) {
			return p;
		}
    	if (root==q) {
			return q;
		}
        int ip=root.val-p.val;
        int iq=root.val-q.val;
        if (ip>0!=iq>0) {
        	return root;
		}else {
			if (ip>0) {
				return lowestCommonAncestor(root.left,p,q);
			}else {
				return lowestCommonAncestor(root.right,p,q);
			}
		}
    }
}