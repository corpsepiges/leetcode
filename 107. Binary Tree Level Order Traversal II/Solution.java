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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<TreeNode>> answerList = new ArrayList<List<TreeNode>>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) {
			return list;
		}
		List<TreeNode> initList = new ArrayList<TreeNode>();
		initList.add(root);
		answerList.add(initList);
		for (int i = 0; i < answerList.size(); i++) {
			List<TreeNode> newList = new ArrayList<TreeNode>();
			for (int j = 0; j < answerList.get(i).size(); j++) {
				TreeNode tree = answerList.get(i).get(j);
				if (tree.left != null) {
					newList.add(tree.left);
				}
				if (tree.right != null) {
					newList.add(tree.right);
				}
			}
			if (newList.size() != 0) {
				answerList.add(newList);
			}
		}
		for (int i = answerList.size()-1; i >=0; i--) {
			List<Integer> l = new ArrayList<Integer>();
			for (int j = 0; j < answerList.get(i).size(); j++) {
				l.add(answerList.get(i).get(j).val);
			}
			list.add(l);
		}
		
		return list;
	}
}