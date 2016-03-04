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
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> list=new ArrayList<Integer>();
        return postorder(root,list);
    }
    public List<Integer> postorder(TreeNode root,List<Integer> list){
    	if (root==null) {
			return list;
		}
    	list=postorder(root.left,list);
    	list=postorder(root.right, list);
    	list.add(root.val);
    	return list;
    }
}