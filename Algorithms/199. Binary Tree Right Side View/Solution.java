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
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> answer=new ArrayList<Integer>();
    	if (root==null) {
    		return answer;
    	}
    	List<TreeNode> list=new ArrayList<TreeNode>();
    	list.add(root);
    	int k=list.size();
    	while (k>0) {
			answer.add(list.get(list.size()-1).val);
			for (int i = 0; i < k; i++) {
				if (list.get(i).left!=null) {
					list.add(list.get(i).left);
				}
				if (list.get(i).right!=null) {
					list.add(list.get(i).right);
				}
				list.remove(i);
				i--;
				k--;
			}
			k=list.size();
		}
    	return answer;
    }
}