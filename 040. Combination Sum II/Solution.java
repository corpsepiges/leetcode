public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return f(candidates,target,candidates.length-1);
    }
    public List<List<Integer>> f(int[] candidates, int target,int l) {
    	List<List<Integer>> ans=new ArrayList<List<Integer>>();
    	if (candidates[0]>target||target<0||l<0) {
			return ans;
		}
    	for (int i =l; i >=0 ; i--) {
			int k=candidates[i];
			if (k==target) {
				List<Integer> list=new ArrayList<Integer>();
				list.add(k);
				ans.add(list);
			}else {
				List<List<Integer>> q=f(candidates,target-k,i-1);
				if (q!=null&&q.size()!=0) {
					for (int j = 0; j < q.size(); j++) {
						List<Integer> list=q.get(j);
						list.add(k);
						ans.add(list);
					}
				}
			}
			while (i>0&&candidates[i]==candidates[i-1]) {
				i--;
			}
		}
    	return ans;
    }
}