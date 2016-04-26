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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ansList=new ArrayList<String>();
        if (root!=null) {
            List<List<TreeNode>> totalList=new ArrayList<List<TreeNode>>();
            List<TreeNode> initList=new ArrayList<TreeNode>();
            initList.add(root);
            totalList.add(initList);
            for (int i = 0; i < totalList.size(); i++) {
                List<TreeNode> list=totalList.get(i);
                TreeNode node=list.get(list.size()-1);
                boolean flag=false;
                if (node.left!=null) {
                    List<TreeNode> leftList=new ArrayList<TreeNode>();
                    leftList.addAll(list);
                    leftList.add(node.left);
                    totalList.add(leftList);
                    flag=true;
                }
                if (node.right!=null) {
                    List<TreeNode> rightList=new ArrayList<TreeNode>();
                    rightList.addAll(list);
                    rightList.add(node.right);
                    totalList.add(rightList);
                    flag=true;
                }
                if (flag) {
                    totalList.remove(i);
                    i--;
                }
            }
            for (int i = 0; i < totalList.size(); i++) {
                List<TreeNode> list=totalList.get(i);
                String ans=""+list.get(0).val;
                for (int j = 1; j < list.size(); j++) {
                    ans+=("->"+list.get(j).val);
                }
                ansList.add(ans);
            }
        }
        return ansList;
    }
}