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
    public int rob(TreeNode root) {
        return root==null?0:Math.max(root.val+robSon(root.left)+robSon(root.right), rob(root.left)+rob(root.right));
    }
    public int robSon(TreeNode root){
        return root==null?0:rob(root.left)+rob(root.right);
    }
}