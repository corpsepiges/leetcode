public class Solution {
    public int maxProfit(int[] prices) {
        int p1=0;
        int p2=0;
        for(int i =1;i<prices.length;i++){
            int test=p1;
            p1=Math.max(p1+prices[i]-prices[i-1],p2);
            p2=Math.max(test,p2);
        }
        return Math.max(p1,p2);
    }
}