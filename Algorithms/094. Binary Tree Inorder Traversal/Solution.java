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
    public List<Integer> inorderTraversal(TreeNode root) {
    	return inorder(root,new ArrayList<Integer>());
    }
    public List<Integer> inorder(TreeNode root,List<Integer> list){
    	if (root!=null) {
			list=inorder(root.left,list);
		    list.add(root.val);
			list=inorder(root.right,list);
		}
    	return list;
    }
}