public class Solution {
    public int climbStairs(int n) {
        if (n<=2) {
            return n;
        }else {
            int[] sk=new int[n];
            sk[0]=1;
            sk[1]=2;
            for (int i =2; i < sk.length; i++) {
                sk[i]=sk[i-1]+sk[i-2];
            }
            return sk[n-1];
        }
    }
}