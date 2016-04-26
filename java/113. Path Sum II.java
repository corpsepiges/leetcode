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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> answerList=new ArrayList<List<Integer>>();
        if (root==null) {
            return answerList;
        }
        List<List<TreeNode>> rootList=new ArrayList<List<TreeNode>>();
        List<TreeNode> initList=new ArrayList<TreeNode>();
        initList.add(root);
        rootList.add(initList);
        for (int i = 0; i < rootList.size(); i++) {
            List<TreeNode> list=rootList.get(i);
            TreeNode node=list.get(list.size()-1);
            if (node.left!=null||node.right!=null) {
                if (node.left!=null) {
                    List<TreeNode> newLeftList=new ArrayList<TreeNode>();
                    newLeftList.addAll(list);
                    newLeftList.add(node.left);
                    rootList.add(newLeftList);
                }
                if (node.right!=null) {
                    List<TreeNode> newRightList=new ArrayList<TreeNode>();
                    newRightList.addAll(list);
                    newRightList.add(node.right);
                    rootList.add(newRightList);
                }
                rootList.remove(i);
                i--;
            }
        }
        for (int i = 0; i < rootList.size(); i++) {
            List<TreeNode> list=rootList.get(i);
            List<Integer> valList=new ArrayList<Integer>();
            int val=0;
            for (int j = 0; j < list.size(); j++) {
                val+=list.get(j).val;
                valList.add(list.get(j).val);
            }
            if (val==sum) {
                answerList.add(valList);
            }
        }
        return answerList;
    }
}