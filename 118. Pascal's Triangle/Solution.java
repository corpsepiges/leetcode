public class Solution {
    public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> answerList = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j==0||j==i) {
					list.add(1);
				}else {
					list.add(answerList.get(i-1).get(j-1)+answerList.get(i-1).get(j));
				}
			}
			answerList.add(list);
		}

		return answerList;
	}
}