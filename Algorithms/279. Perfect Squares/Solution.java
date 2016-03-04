public class Solution {
	Map<Integer, Integer> map=new HashMap<Integer, Integer>();
    public int numSquares(int n) {
    	if (n<4) {
			return n;
		}
        if (map.get(n)==null) {
			int s=(int) Math.sqrt(n);
			if (s*s==n) {
				return 1;
			}
			int ans=numSquares(n-s*s);
			//凭感觉处理了一下测试的最小值
			for (int i = s-1; i >=Math.max(s/2, 1); i--) {
				int t=numSquares(n-i*i);
				if (t<ans) {
					ans=t;
				}
			}
			map.put(n, 1+ans);
		}
        return map.get(n);
    }
}