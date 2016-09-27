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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null) {
            return 0;
        }
        return sum(root.left,true)+sum(root.right,false);
    }
    public int sum(TreeNode root,boolean flag){
        if (root==null) {
            return 0;
        }
        if (flag&&root.left==null&&root.right==null) {
            return root.val;
        }
        return sum(root.left, true)+sum(root.right,false);
    }
}