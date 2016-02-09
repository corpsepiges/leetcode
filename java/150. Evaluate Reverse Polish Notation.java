public class Solution {
    public int evalRPN(String[] tokens) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")) {
				int b = list.get(list.size() - 1);
				list.remove(list.size() - 1);
				int a = list.get(list.size() - 1);
				list.remove(list.size() - 1);
				int sum = a + b;
				list.add(sum);
			} else if (tokens[i].equals("-")) {
				int b = list.get(list.size() - 1);
				list.remove(list.size() - 1);
				int a = list.get(list.size() - 1);
				list.remove(list.size() - 1);
				int sum = a - b;
				list.add(sum);
			} else if (tokens[i].equals("*")) {
				int b = list.get(list.size() - 1);
				list.remove(list.size() - 1);
				int a = list.get(list.size() - 1);
				list.remove(list.size() - 1);
				int sum = a * b;
				list.add(sum);
			} else if (tokens[i].equals("/")) {
				int b = list.get(list.size() - 1);
				list.remove(list.size() - 1);
				int a = list.get(list.size() - 1);
				list.remove(list.size() - 1);
				int sum = a / b;
				list.add(sum);
			} else {
				list.add(Integer.parseInt(tokens[i]));
			}
		}
		return list.get(0);
	}
}