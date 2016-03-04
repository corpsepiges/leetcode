public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answerList=new ArrayList<List<Integer>>();
        for (int i = 1; i <=n; i++) {
			List<Integer> list=new ArrayList<Integer>();
			list.add(i);
			answerList.add(list);
		}
        for (int i = 0; i <answerList.size(); i++) {
			if (answerList.get(i).size()<k) {
				if ((n-answerList.get(i).get(answerList.get(i).size()-1))<(k-answerList.get(i).size())) {
					answerList.remove(i);
					i--;
				}else {
					for (int j = answerList.get(i).get(answerList.get(i).size()-1)+1; j <=n; j++) {
						System.out.println("j="+j);
						List<Integer> alist=new ArrayList<Integer>();
						for (int l = 0; l <answerList.get(i).size(); l++) {
							alist.add(answerList.get(i).get(l));
						}
						alist.add(j);
                        answerList.add(alist);						
					}
					answerList.remove(i);
					System.out.println();
					i--;
				}
			}
		}
    	return answerList;
    }
}