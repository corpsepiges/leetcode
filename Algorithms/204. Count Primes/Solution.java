public class Solution {
    public int countPrimes(int n) {
    	boolean[] flag=new boolean[n];
    	int ans=0;
    	for (int i = 2; i < flag.length; i++) {
			if (!flag[i]) {
				ans++;
				for (int j = i; j < flag.length; j+=i) {
					flag[j]=true;
				}
			}
		}
    	return ans;
    }
}