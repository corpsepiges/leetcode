/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    List<TreeNode> list=new ArrayList<TreeNode>();
    public BSTIterator(TreeNode root) {
        if(root!=null){
            list.add(root);
        }
        while(list.size()>0){
            TreeNode node=list.get(list.size()-1);
            if(node.left!=null){
                list.add(node.left);
                node.left=null;
            }else{
                break;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return list.size()!=0;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode test=list.get(list.size()-1);
        list.remove(list.size()-1);
        if(test.right!=null){
            list.add(test.right);
            while(true){
                TreeNode node=list.get(list.size()-1);
                if(node.left!=null){
                    list.add(node.left);
                    node.left=null;
                }else {
                    break;
                }
            }
        }
        return test.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */