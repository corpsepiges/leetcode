public class Solution {
    public int numTrees(int n) {
    	return f(n,new HashMap<Integer, Integer>());
    }
    public int f(int n,Map<Integer,Integer> map){
    	if (map.get(n)!=null) {
			return map.get(n);
		}else {
			
			if (n==1||n==0) {
				return 1;
			}else {
				int sum=0;
				for (int i = 0; i < n; i++) {
					int left=f(i,map);
					int right=f((n-1-i),map);
					sum+=(left*right);
				}
				map.put(n,sum);
				return sum;
			}
		}
    }
}