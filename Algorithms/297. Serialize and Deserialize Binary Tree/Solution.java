/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<TreeNode> list=new ArrayList<TreeNode>();
        list.add(root);
        StringBuffer sb=new StringBuffer();
        while(list.size()!=0){
            for(int i=0;i<list.size();i++){
                TreeNode node=list.get(i);
                if(node==null){
                    sb.append("null,");
                }else{
                    sb.append(node.val);
                    sb.append(",");
                    list.add(node.left);
                    list.add(node.right);
                }
                list.remove(i);
                i--;
            }
        }
        String ans=sb.toString();
        return ans.substring(0,sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs=data.split(",");
        if(strs[0].equals("null")){
            return null;
        }
        TreeNode ans=new TreeNode(Integer.parseInt(strs[0]));
        List<TreeNode> list=new ArrayList<TreeNode>();
        list.add(ans);
        int i=1;
        while(i<strs.length){
            List<TreeNode> sonList=new ArrayList<TreeNode>();
            for(TreeNode node:list){
                if(i>=strs.length){
                    return ans;
                }
                if(!strs[i].equals("null")){
                    TreeNode left=new TreeNode(Integer.parseInt(strs[i]));
                    node.left=left;
                    sonList.add(left);
                }
                i++;
                if(i>=strs.length){
                    return ans;
                }
                if(!strs[i].equals("null")){
                    TreeNode right=new TreeNode(Integer.parseInt(strs[i]));
                    node.right=right;
                    sonList.add(right);
                }
                i++;
                
            }
            list=sonList;
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));