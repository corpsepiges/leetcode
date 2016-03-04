public class Solution {
    public int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		int[] change = new int[prices.length - 1];
		for (int i = 0; i < change.length; i++) {
			change[i] = prices[i + 1] - prices[i];
		}
		int sum0 = 0;
		int s0 = 0;
		int b=0;
		int e=0;
		int begin0 = 0;
		int end0 = 0;
		for (int i = 0; i < change.length; i++) {
			s0 += change[i];
			if (s0 < 0) {
				s0 = 0;
				b=i+1;
				e=i+1;
			}
			if (change[i] > 0) {
				e=i;
			}
			if (s0 > sum0) {
				sum0 = s0;
				begin0=b;
				end0=e;
			}
		}
		int sum1 = 0;
		int s1 = 0;
		for (int i = 0; i <begin0; i++) {
			s1 += change[i];
			if (s1 < 0) {
				s1 = 0;
			}
			if (s1 > sum1) {
				sum1 = s1;
			}
		}
		int sum2 = 0;
		int s2 = 0;
		for (int i = end0+1; i <change.length; i++) {
			s2 += change[i];
			if (s2 < 0) {
				s2 = 0;
			}
			if (s2 > sum2) {
				sum2 = s2;
			}
		}
		int sum3 = 0;
		int s3 = 0;
		for (int i = begin0+1; i <end0; i++) {
			s3 += change[i];
			if (s3 > 0) {
				s3 = 0;
			}
			if (s3 < sum3) {
				sum3 = s3;
			}
		}
		return sum0+Math.max(0-sum3, Math.max(sum1, sum2));
	}
}