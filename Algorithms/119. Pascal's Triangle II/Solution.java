public class Solution {
    public List<Integer> getRow(int rowIndex) {
    	Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for (int i = 0; i <=rowIndex; i++) {
			map.put(i, 1);
			//反向计算防止值在使用前被覆盖
			for (int j = i-1; j >=1; j--) {
				map.put(j, map.get(j-1)+map.get(j));
			}
		}
        List<Integer> answerList=new ArrayList<Integer>();
    	for (int i = 0; i <=rowIndex; i++) {
			answerList.add(map.get(i));
		}
    	return answerList;
    }
}