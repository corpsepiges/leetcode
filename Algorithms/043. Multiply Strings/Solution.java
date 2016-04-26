public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0")||num2.equals("0")) {
            return "0";
        }
        if (num1.length()<num2.length()) {
            return multiply(num2,num1);
        }
        int l1=num1.length();
        int[] n1=new int[l1];
        for (int i = 0; i <l1; i++) {
            n1[l1-i-1]=Integer.parseInt(num1.substring(i, i+1));
        }
        int l2=num2.length();
        int[] n2=new int[l1];
        for (int i = 0; i <l2; i++) {
            n2[l2-i-1]=Integer.parseInt(num2.substring(i, i+1));
        }
        int[] a=new int[l1+l2-1];
        int sum=0;
        int carry=0;
        for (int i = 0; i < a.length; i++) {
            // 每一位乘级相加的结果
            for (int j = Math.max(0,i-l2+1); j <= Math.min(i,l1-1); j++) {
                sum += n1[j] * n2[i-j];
            }
            // 加进位
            sum += carry;
            carry = sum / 10;
            sum%=10;
            a[i]=sum;
            sum = 0;
        }
        StringBuffer sb=new StringBuffer();
        if (carry!=0) {
            sb.append(String.valueOf(carry));
        }
        for (int i = a.length-1; i >=0 ; i--) {
            sb.append(String.valueOf(a[i]));
        }
        return sb.toString();
    }
}