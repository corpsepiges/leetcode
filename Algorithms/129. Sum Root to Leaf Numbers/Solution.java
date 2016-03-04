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
    public int sumNumbers(TreeNode root) {
    	if (root==null) {
			return 0;
		}
    	List<List<TreeNode>> totalList=new ArrayList<List<TreeNode>>();
    	List<TreeNode> initList=new ArrayList<TreeNode>();
    	initList.add(root);
    	totalList.add(initList);
    	for (int i = 0; i < totalList.size(); i++) {
    		List<TreeNode> list=totalList.get(i);
    		TreeNode node=list.get(list.size()-1);
    		if (node.left!=null||node.right!=null) {
				if (node.left!=null) {
					List<TreeNode> newList=new ArrayList<TreeNode>();
					newList.addAll(list);
					newList.add(node.left);
					totalList.add(newList);
				}
				if (node.right!=null) {
					List<TreeNode> newList=new ArrayList<TreeNode>();
					newList.addAll(list);
					newList.add(node.right);
					totalList.add(newList);
				}
				totalList.remove(i);
				i--;
			}
		}
    	long answer=0;
    	for (int i = 0; i < totalList.size(); i++) {
    		List<TreeNode> list=totalList.get(i);
    		long sum=0;
			for (int j = 0; j < list.size(); j++) {
				sum+=list.get(j).val;
				sum*=10;
			}
			sum/=10;
			answer+=sum;
		}
    	return Integer.valueOf(""+answer);
    }
}