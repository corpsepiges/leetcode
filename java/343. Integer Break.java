public class Solution {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
		{
			put(2, 2);
			put(3, 3);
		}
	};
	public int integerBreak(int n) {
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		return f(n);
	}

	public int f(int n) {
		if (map.get(n) == null) {
			int sum = 0;
			for (int i = 2; i < n - 1; i++) {
				int test = f(i) * f(n - i);
				if (test > sum) {
					sum = test;
				}
			}
			map.put(n, sum);
		}
		return map.get(n);
	}
}