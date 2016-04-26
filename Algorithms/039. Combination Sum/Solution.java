public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return f(candidates, target, new HashMap<Integer, List<List<Integer>>>());
    }
    public List<List<Integer>> f(int[] candidates, int target,HashMap<Integer, List<List<Integer>>> map){
        if (map.get(target)==null) {
            List<List<Integer>> ans=new ArrayList<List<Integer>>();
            if (target<candidates[0]) {
                return ans;
            }
            for (int i = 0; i < candidates.length; i++) {
                int k=candidates[i];
                if (k<target) {
                    List<List<Integer>> list=f(candidates,target-k,map);
                    if (list!=null&&list.size()!=0) {
                        for (int j = 0; j < list.size(); j++) {
                            if (list.get(j).get(0)>=k) {
                                List<Integer> l=new ArrayList<Integer>();
                                l.add(k);
                                l.addAll(list.get(j));
                                ans.add(l);
                            }
                        }
                    }
                }else if (k==target) {
                    List<Integer> l=new ArrayList<Integer>();
                    l.add(k);
                    ans.add(l);
                }else {
                    break;
                }
            }
            map.put(target, ans);
            return ans;
        }
        return map.get(target);
    }
}