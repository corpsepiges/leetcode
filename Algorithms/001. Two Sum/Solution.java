public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		Map map = new HashMap();
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i);
		}
		for (int i = 0; i < numbers.length; i++) {
			int gap = target - numbers[i];
			if (map.get(gap) != null && (int) map.get(gap) != i) {
				res[0] = i + 1;
				res[1] = (int) map.get(gap) + 1;
				break;
			}
		}
		return res;
	}
}