public class Solution {
    public int[][] generateMatrix(int n) {
		int[][] answer = new int[n][n];
		// 顶部
		int t = 0;
		// 底部
		int b = n - 1;
		// 左边
		int l = 0;
		// 右边
		int r = n - 1;
		int a = 1;
		while (true) {
			// 左
			for (int i = l; i <= r; i++) {
				answer[t][i] = a;
				a++;
			}
			t++;
			if (t > b) {
				return answer;
			}
			// 下
			for (int i = t; i <= b; i++) {
				answer[i][r] = a;
				a++;
			}
			r--;
			if (l > r) {
				return answer;
			}
			// 右
			for (int i = r; i >= l; i--) {
				answer[b][i] = a;
				a++;
			}
			b--;
			if (t > b) {
				return answer;
			}
			// 上
			for (int i = b; i >= t; i--) {
				answer[i][l] = a;
				a++;
			}
			l++;
			if (l > r) {
				return answer;
			}

		}
	}
}