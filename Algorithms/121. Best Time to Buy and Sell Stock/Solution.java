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
        int s = 0;
        int begin = 0;
        int end = 0;
        for (int i = 0; i < change.length; i++) {
            s += change[i];
            if (s < 0) {
                s = 0;
                begin = i + 1;
                end = i + 1;
            }
            if (change[i] > 0) {
                end = i;
            }
            if (s > sum) {
                sum = s;
            }

        }
        return sum;
    }
}