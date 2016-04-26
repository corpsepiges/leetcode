public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] ans=new int[triangle.get(triangle.size()-1).size()];
        for (int i = 0; i <triangle.get(triangle.size()-1).size(); i++) {
            ans[i]=triangle.get(triangle.size()-1).get(i);
        }
        if (triangle.size()>1) {
            for (int i = triangle.size()-2; i >=0; i--) {
                List<Integer> list=triangle.get(i);
                for (int j = 0; j < list.size(); j++) {
                    ans[j]=list.get(j)+(ans[j]<ans[j+1]?ans[j]:ans[j+1]);
                }
            }
        }
        return ans[0];
    }
}