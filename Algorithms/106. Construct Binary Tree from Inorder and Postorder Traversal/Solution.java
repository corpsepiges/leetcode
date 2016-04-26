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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder,0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode build(int[] inorder, int[] postorder,int is,int ie,int ps,int pe){
        if(ps>pe){
            return null;
        }
        int val=postorder[pe];
        TreeNode node=new TreeNode(val);
        int i = is;
        for (; i <=ie; i++) {
            if (inorder[i]==val) {
                break;
            }
        }
        int rang=i-is;
        node.left=build(inorder, postorder,is,i-1,ps,ps+rang-1);
        node.right=build(inorder,postorder,i+1,ie,ps+rang,pe-1);
        return node;
        
    }
}