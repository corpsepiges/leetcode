public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==n){
            return n;
        }
        int s=(int) Math.pow(2,(int) (Math.log(m^n)/Math.log(2))+1);
        return ((m&n)/s)*s;
    }
}