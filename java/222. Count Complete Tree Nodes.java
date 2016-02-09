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
    public int countNodes(TreeNode root) {
    	if (root==null) {
			return 0;
		}
        int l=getLeft(root);
        int r=getRight(root);
        if (l==r) {
			return (2<<(l-1)) - 1;  
		}
        return 1+countNodes(root.left) + countNodes(root.right) ;  
    }
    public int getLeft(TreeNode root){
    	int h=0;
    	while(root!=null){
    	    h++;
    	    root=root.left;
    	}
    	return h;
    }
    public int getRight(TreeNode root){
        int h=0;
    	while(root!=null){
    	    h++;
    	    root=root.right;
    	}
    	return h;
    }
}