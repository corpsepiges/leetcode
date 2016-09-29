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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root==null) {
            return null;
        }else if (root.left!=null) {
            TreeNode ans=upsideDownBinaryTree(root.left);
            TreeNode test=ans;
            while (test.right!=null) {
                test=test.right;
            }
            if (root.right!=null) {
                test.left=new TreeNode(root.right.val);
            }
            test.right=new TreeNode(root.val);
            return ans;
        }else{
            return new TreeNode(root.val);
        }
    }
}