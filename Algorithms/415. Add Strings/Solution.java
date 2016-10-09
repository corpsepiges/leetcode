public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer sb=new StringBuffer();
        int l1=num1.length();
        int l2=num2.length();
        char[] c1=num1.toCharArray();
        char[] c2=num2.toCharArray();
        int carry=0;
        for (int i = 0; i <l1||i<l2; i++) {
            int a1=i<l1?c1[l1-1-i]-48:0;
            int a2=i<l2?c2[l2-1-i]-48:0;
            int ans=a1+a2+carry;
            sb.append(ans%10);
            carry=ans/10;
        }
        if (carry==1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}