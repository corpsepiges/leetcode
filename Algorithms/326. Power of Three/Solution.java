public class Solution {
    public boolean isPowerOfThree(int n) {
        return n>0&&Math.pow(3, Math.ceil(Math.log(n)/Math.log(3)))==n;
    }
}