public class Solution {
    public String toHex(int num) {
        if (num==0) {
            return "0";
        }
        long test=num>=0?num:1l+num-Integer.MIN_VALUE+Integer.MAX_VALUE;
        String ans="";
        while (test!=0) {
            int t=(int) (test%16);
            if (t<10) {
                ans=String.valueOf(t)+ans;
            }else{
                ans=String.valueOf((char)('a'+t-10))+ans;
            }
            test/=16;
        }
        return ans;
    }
}