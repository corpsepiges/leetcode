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
    Map<TreeNode, Integer> mapOne=new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> mapTwo=new HashMap<TreeNode, Integer>();
    public int maxPathSum(TreeNode root) {
        return findMax(root, true);
    }
    public int findMax(TreeNode root,boolean flag){
        if (root==null) {
            return 0;
        }
        if (flag) {
            if (mapTwo.get(root)!=null) {
                return mapTwo.get(root);
            }
        }else {
            if (mapOne.get(root)!=null) {
                return mapOne.get(root);
            }
        }
        int leftOne=findMax(root.left, false);
        int rightOne=findMax(root.right, false);
        leftOne=Math.max(0, leftOne);
        rightOne=Math.max(0, rightOne);
        if (flag) {
            int test=root.val+leftOne+rightOne;
            if (root.left!=null) {
                int leftTwo=findMax(root.left, true);
                test=Math.max(test, leftTwo);
            }
            if (root.right!=null) {
                int rightTwo=findMax(root.right, true);
                test=Math.max(test, rightTwo);
            }
            mapTwo.put(root, test);
            return test;
        }else{
            int ans=root.val+Math.max(leftOne, rightOne);
            mapOne.put(root, ans);
            return ans;
        }
    }
}