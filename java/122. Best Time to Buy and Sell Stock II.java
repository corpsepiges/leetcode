public class Solution {
    public int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		int[] change = new int[prices.length - 1];
		for (int i = 0; i < change.length; i++) {
			change[i] = prices[i + 1] - prices[i];
		}
		int sum = 0;
		for (int i = 0; i < change.length; i++) {
			if (change[i]>0) {
				sum+=change[i];
			}
		}
		return sum;
	}
}