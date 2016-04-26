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
        String sp=f(root,p);
        sp=sp.substring(0,sp.length()-1);
        String sq=f(root,q);
        sq=sq.substring(0,sq.length()-1);
        for (int i = 0; i < Math.min(sp.length(), sq.length()); i++) {
            String kp=sp.substring(i,i+1);
            String kq=sq.substring(i,i+1);
            if (kp.equals(kq)) {
                if (kp.equals("0")) {
                    root=root.left;
                }else {
                    root=root.right;
                }
            }else {
                return root;
            }
        }
        return root;
    }
    public String f(TreeNode root, TreeNode p){
        if (root==null) {
            return "3";
        }
        if (root==p) {
            return "2";
        }
        String left=f(root.left,p);
        String right=f(root.right,p);
        if (left.substring(left.length()-1,left.length()).equals("2")) {
            return "0"+left;
        }else {
            return "1"+right;
        }
    }
}