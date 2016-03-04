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
    public List<TreeNode> generateTrees(int n) {
        return f(1,n,new HashMap<String, List<TreeNode>>());
    }
    public List<TreeNode> f(int s,int e,Map<String,List<TreeNode>> map) {
    	if (map.get(""+s+","+e)==null) {
    		List<TreeNode> ans=new ArrayList<TreeNode>();
    		if (s>e) {
				ans.add(null);
			}else if (s==e) {
				ans.add(new TreeNode(s));
			}else {
				for (int i = s; i <=e; i++) {
					List<TreeNode> left=f(s,i-1,map);
					List<TreeNode> right=f(i+1,e,map);
					for (int j = 0; j < left.size(); j++) {
						for (int k = 0; k < right.size(); k++) {
							TreeNode node=new TreeNode(i);
							node.left=left.get(j);
							node.right=right.get(k);
							ans.add(node);
						}
					}
				}
			}
    		map.put(""+s+","+e, ans);
			return ans;
		}
    	return map.get(""+s+","+e);
    }
}