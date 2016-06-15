public class Solution {
    public int myAtoi(String str) {
        char[] cs=str.toCharArray();
        long ans=0;
        int sign=1;
        boolean signFlag=true;
        int i=0;
        boolean zeroFlag=true;
        while (i < cs.length) {
            if (zeroFlag) {
                while (cs[i]==' ') {
                    i++;
                }
                zeroFlag=false;
            }
            if (!zeroFlag&&cs[i]==' ') {
                break;
            }
            if (cs[i]=='-'||cs[i]=='+') {
                if (signFlag) {
                    sign=44-cs[i];
                    signFlag=false;
                }else{
                    return 0;
                }
            }else if(cs[i]>='0'&&cs[i]<='9'){
                ans=10*ans+cs[i]-48;
                if (sign==1&&ans>=Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (sign==-1&&ans-1>=Integer.MAX_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }else{
                break;
            }
            i++;
        }
        return (int) (ans*sign);
    }
}