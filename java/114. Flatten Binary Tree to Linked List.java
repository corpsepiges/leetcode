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
    List<TreeNode> list=new ArrayList<TreeNode>();
    public void flatten(TreeNode root) {
        if (root!=null) {
            f(root);
            for (int i = 0; i < list.size()-1; i++) {
                list.get(i).right=list.get(i+1);
                list.get(i).left=null;
            }
            root=list.get(0);
        }
    }
    public void f(TreeNode root){
        if (root!=null) {
            list.add(root);
            f(root.left);
            f(root.right);
        }
    }
}