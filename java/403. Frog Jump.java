public class Solution {
    int[] stones;
    int[][] ans;
    public boolean canCross(int[] stones) {
        if (stones.length<=1) {
            return true;
        }else if (stones.length==2) {
            return stones[1]==1;
        }
        this.stones=stones;
        this.ans=new int[stones.length][stones.length];
        return f(1, 1);
    }
    public boolean f(int startIndex,int step){
        if (startIndex==stones.length-1) {
            return true;
        }
        if (ans[startIndex][step]==-1) {
            return false;
        }
        for (int i = startIndex+1; i < stones.length; i++) {
            for (int j = -1; j <=1; j++) {
                if (stones[i]==stones[startIndex]+step+j) {
                    if (f(i,step+j)) {
                        return true;
                    }else{
                        ans[i][step+j]=-1;
                    }
                }
            }
        }
        return false;
    }
}