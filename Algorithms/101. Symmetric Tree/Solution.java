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
    public boolean isSymmetric(TreeNode root) {
        if (root==null) {
            return true;
        }else {
            TreeNode p=root.left;
            TreeNode q=root.right;
            return isSy(p, q);
        }
    }
    public boolean isSy(TreeNode p,TreeNode q){
        if (p==null&&q==null) {
            return true;
        }else if (p==null||q==null) {
            return false;
        }
        if (p.val!=q.val) {
            return false;
        }else{
            return isSy(p.right, q.left)&&isSy(p.left, q.right);
        }
    }
}