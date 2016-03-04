public class Solution {
    public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		String answer = "1";
		for (int i = 0; i < n - 1; i++) {
			answer = new Solution().readNum(answer);
		}
		return answer;
	}

	public String readNum(String num) {
		int n = 1;
		String t = num.substring(0, 1);
		StringBuffer answer=new StringBuffer();
		String k = "";
		for (int i = 1; i < num.length(); i++) {
			k = num.substring(i, i + 1);
			if (k.equals(t)) {
				n++;
			} else {
				answer=answer.append(n).append(t);
				t = k;
				n = 1;
			}
		}
		answer = answer.append(n).append(t);
		return answer.toString();
	}
}