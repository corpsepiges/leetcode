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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	return build(preorder, inorder,0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder, int[] inorder,int ps,int pe,int is,int ie){
    	if(ps>pe){
    		return null;
    	}
    	int val=preorder[ps];
    	TreeNode node=new TreeNode(val);
    	int i = is;
    	for (; i <=ie; i++) {
			if (inorder[i]==val) {
				break;
			}
		}
    	int rang=i-is;
    	node.left=build(preorder, inorder,ps+1,ps+rang,is,i-1);
    	node.right=build(preorder,inorder,ps+rang+1,pe,i+1,ie);
    	return node;
    	
    }
}