public class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length()==k) {
            return "0";
        }
        int first=0;
        while (k>0) {
            int index=num.length()-1;
            for (int i = first; i < num.length()-1; i++) {
                if (num.charAt(i)>num.charAt(i+1)) {
                    index=i;
                    break;
                }
            }
            if (index==num.length()-1) {
                num=num.substring(0,num.length()-k);
                k=0;
            }else{
                num=num.substring(0,index)+num.substring(index+1, num.length());
                k--;
                if (index>0) {
                    first=index-1;
                }else{
                    first=0;
                }
            }
        }
        int zero=0;
        for (int i = 0; i < num.length()-1; i++) {
            if (num.charAt(i)!='0') {
                zero=i;
                break;
            }
        }
        return num.substring(zero,num.length());
    }
}