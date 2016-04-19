public class Solution {
    public boolean isPowerOfFour(int num) {
        return num>0&&Math.pow(4, Math.ceil(Math.log(num)/Math.log(4)))==num;
    }
}