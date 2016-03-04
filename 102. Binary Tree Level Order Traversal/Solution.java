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
    public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<TreeNode>> answerList = new ArrayList<List<TreeNode>>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) {
			return list;
		}
		List<TreeNode> initList = new ArrayList<TreeNode>();
		initList.add(root);
		answerList.add(initList);
		for (int i = 0; i < answerList.size(); i++) {
			List<Integer> l = new ArrayList<Integer>();
			List<TreeNode> newList = new ArrayList<TreeNode>();
			for (int j = 0; j < answerList.get(i).size(); j++) {
				TreeNode tree = answerList.get(i).get(j);
				l.add(answerList.get(i).get(j).val);
				if (tree.left != null) {
					newList.add(tree.left);
				}
				if (tree.right != null) {
					newList.add(tree.right);
				}
			}
			list.add(l);
			if (newList.size() != 0) {
				answerList.add(newList);
			}
		}
		return list;
	}
}