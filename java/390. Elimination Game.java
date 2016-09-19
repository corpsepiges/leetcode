public class Solution {
    public int lastRemaining(int n) {
        return f(n,true);
    }
    //flag：true表示从左向右，false表示从又向左，当且近当从右向左且n为偶数时，需要-1
    public int f(int n,boolean flag){
        if (n<=2) {
            return flag?n:1;
        }else{
            return 2*f(n/2,!flag)-(((n&1)==0&&!flag)?1:0);
        }
    }
}