public class Solution {
    public boolean isAdditiveNumber(String num) {
        int length=num.length();
        int l=Math.min(length, length*2/3+3);
        for (int i = 0; i < l-2; i++) {
			String first=num.substring(0,i+1);
			for (int j = i+1; j < l-1; j++) {
				int f=i+1;
				int s=j-i;
				int t=length-j-1;
				if (t>=s&&t>=f) {
					String second=num.substring(i+1,j+1);
					String third=num.substring(j+1,length);
					if (f(first, second, third)) {
						return true;
					}
				}
			}
		}
        return false;
    }
    public boolean f(String first,String second,String third){
    	if (third.equals("")) {
			return true;
		}
    	int f=first.length();
    	int s=second.length();
    	int t=third.length();
    	if (t<s||t<f) {
			return false;
		}
    	String sum=addString(first, second);
    	if (sum.length()>t) {
			return false;
		}
    	String test=third.substring(0,sum.length());
    	if (sum.equals(test)) {
			return f(second, sum, third.substring(sum.length(),t));
		}
    	return false;
    }
    public String addString(String sa,String sb){
    	int al=sa.length();
    	int bl=sb.length();
    	if (al<bl) {
			return  addString(sb, sa);
		}
    	char[] a=sa.toCharArray();
    	char[] b=sb.toCharArray();
    	int[] sum=new int[al];
    	boolean flag=false;
    	for (int i = 0; i < bl; i++) {
			sum[al-i-1]=Integer.parseInt(""+b[bl-i-1])+Integer.parseInt(""+a[al-i-1])+(flag?1:0);
			if (sum[al-i-1]>=10) {
				sum[al-i-1]-=10;
				flag=true;
			}else{
				flag=false;
			}
		}
    	for (int i = 0; i < al-bl; i++) {
			sum[i]=Integer.parseInt(""+a[i]);
		}
    	StringBuffer sbf=new StringBuffer();
    	if (!flag||al==bl) {
    		for (int i = 0; i < sum.length; i++) {
    			sbf.append(String.valueOf(sum[i]));
    		}
    		if (flag) {
				return "1"+sbf.toString();
			}else {
				return sbf.toString();
			}
		}else {
			sum[al-bl-1]++;
			for (int i = 0; i < sum.length; i++) {
    			sbf.append(String.valueOf(sum[i]));
    		}
			return sbf.toString();
		}
    }
}