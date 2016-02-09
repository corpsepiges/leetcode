/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node!=null) {
    		Map<UndirectedGraphNode, Integer> initMap=f(node,new HashMap<UndirectedGraphNode, Integer>());
    		Map<UndirectedGraphNode, Integer> map=new HashMap<UndirectedGraphNode, Integer>();
    		map.put(node, 0);
    		List<UndirectedGraphNode> list=new ArrayList<UndirectedGraphNode>();
    		list.add(node);
    		List<UndirectedGraphNode> ans=new ArrayList<UndirectedGraphNode>();
    		UndirectedGraphNode init=new UndirectedGraphNode(node.label);
    		ans.add(init);
    		int k=1;
    		for (UndirectedGraphNode ugn : initMap.keySet()) {
    			if (ugn!=node) {
					map.put(ugn, k);
					list.add(ugn);
					ans.add(new UndirectedGraphNode(ugn.label));
					k++;
				}
    		}
    		for (int i = 0; i < list.size(); i++) {
				List<UndirectedGraphNode> neis=list.get(i).neighbors;
				UndirectedGraphNode u=ans.get(i);
				for (int j = 0; j < neis.size(); j++) {
					u.neighbors.add(ans.get(map.get(neis.get(j))));
				}
			}
    		return init;
		}
    	return null;
    }
    public Map<UndirectedGraphNode, Integer> f(UndirectedGraphNode node,Map<UndirectedGraphNode, Integer> map){
    	if (node!=null&&map.get(node)==null) {
    		map.put(node, 1);
    		List<UndirectedGraphNode> list=node.neighbors;
    		if (list!=null) {
				for (int i = 0; i < list.size(); i++) {
					map=f(list.get(i),map);
				}
			}
		}
    	return map;
    }
}