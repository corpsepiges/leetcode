public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
		int[] n = new int[gas.length];
		for (int i = 0; i < n.length; i++) {
			n[i] = gas[i] - cost[i];
		}
		int sum = 0;
		int begin = 0;
		int truebegin=0;
		for (int i = 0; i < n.length*2; i++) {
			sum += n[i%n.length];
			while (sum < 0) {
				sum -= n[truebegin];
				begin++;
				truebegin=begin%n.length;
			}
			if (i-begin>=n.length) {
				return truebegin;
			}
		}
		return -1;
	}
}