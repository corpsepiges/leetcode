public class Solution {
    public boolean isPerfectSquare(int num) {
        int x=num;
        while(true){
            int t=(x+num/x)/2;
            if (t*t==num||(t-1)*(t-1)==num||(t+1)*(t+1)==num) {
                return true;
            }
            if (x==t||x==t-1||x==t+1) {
                return false;
            }
            x=t;
        }
    }
}