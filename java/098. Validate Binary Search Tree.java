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
    public boolean isValidBST(TreeNode root) {
    	if (root==null) {
			return true;
		}
    	List<Integer> list=inorder(root,new ArrayList<Integer>());
    	if (list.size()<2) {
			return true;
		}
    	for (int i = 0; i < list.size()-1; i++) {
			if (list.get(i)>=list.get(i+1)) {
				return false;
			}
		}
    	return true;
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