public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==-2147483648&&divisor==-1){
            return 2147483647;
        }
        return dividend/divisor;
    }
}