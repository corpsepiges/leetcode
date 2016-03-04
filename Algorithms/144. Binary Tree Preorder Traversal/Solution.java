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
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> list=new ArrayList<Integer>();
        return preorder(root,list);
    }
    public List<Integer> preorder(TreeNode root,List<Integer> list){
    	if (root==null) {
			return list;
		}
    	list.add(root.val);
    	list=preorder(root.left,list);
    	list=preorder(root.right, list);
    	return list;
    }
}