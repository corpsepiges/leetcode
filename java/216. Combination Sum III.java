public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answerList = new ArrayList<List<Integer>>();
        for (int i = 1; i < 10; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(i);
            answerList.add(list);
        }
        for (int i = 0; i < answerList.size(); i++) {
            List<Integer> list = answerList.get(i);
            int length=list.size();
            int value=n-sum(list);
            if (length== k && value==0) {
                continue;
            } else {
                if (value>0) {
                    for (int j = list.get(length- 1) + 1; j <=(value>9?9:value); j++) {
                        if (length<k) {
                            List<Integer> newList = new ArrayList<Integer>();
                            newList.addAll(list);
                            newList.add(j);
                            answerList.add(newList);
                        }
                    }
                }
                answerList.remove(i);
                i--;
            }
        }
        return answerList;
    }
    public int sum(List<Integer> list){
        int sum=0; 
        for (int i = 0; i < list.size(); i++) {
            sum+=list.get(i);
        }
        return sum;
    }
}