/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root!=null) {
            List<List<TreeLinkNode>> sumList=new ArrayList<List<TreeLinkNode>>();
            List<TreeLinkNode> initList=new ArrayList<TreeLinkNode>();
            initList.add(root);
            sumList.add(initList);
            for (int i = 0; i < sumList.size(); i++) {
                List<TreeLinkNode> list=sumList.get(i);
                List<TreeLinkNode> newList=new ArrayList<TreeLinkNode>();
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(i).left!=null) {
                        newList.add(list.get(j).left);
                        newList.add(list.get(j).right);
                    }
                }
                if (newList.size()!=0) {
                    sumList.add(newList);
                }
            }
            for (int i = 0; i < sumList.size(); i++) {
                List<TreeLinkNode> list=sumList.get(i);
                for (int j = 0; j < list.size(); j++) {
                    if (j<list.size()-1) {
                        list.get(j).next=list.get(j+1);
                    }else {
                        list.get(j).next=null;
                    }
                }
            }
        }
    }
}