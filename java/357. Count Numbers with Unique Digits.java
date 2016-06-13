public class Solution {
    List<Integer> list;
    List<Integer> sumList;
    public int countNumbersWithUniqueDigits(int n) {
        if(list==null){
            list=new ArrayList<Integer>();
            sumList=new ArrayList<Integer>();
            list.add(1);
            list.add(9);
            sumList.add(1);
            sumList.add(10);
        }
        for(int i=sumList.size();i<=n;i++){
            list.add(list.get(i-1)*(9-i+2));
            sumList.add(sumList.get(i-1)+list.get(i));
        }
        return sumList.get(n);
    }
}