public class Solution {
    List<Integer> list=new ArrayList<Integer>(){
        {
            add(0);
        }
    };
    public int[] countBits(int num) {
        if (num>=list.size()) {
            for (int i = list.size(); i < num+1; i++) {
                list.add(1+list.get(i-(int)Math.pow(2, (int)(Math.log(i)/Math.log(2)))));
            }
        }
        int[] ans=new int[num+1];
        for (int i = 0; i < ans.length; i++) {
            ans[i]=list.get(i);
        }
        return ans;
    }
}