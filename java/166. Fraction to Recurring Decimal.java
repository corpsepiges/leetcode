public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
    	long n=numerator;
    	long d=denominator;
    	if (d==0) {
			return null;
		}
    	if (n==0) {
			return "0";
		}
    	if (n%d==0) {
    		return String.valueOf(n/d);
    	}
    	boolean flag=true;
    	if (n<0) {
    		n=0-n;
    		flag=!flag;
		}
		if (d<0) {
    		d=0-d;
    		flag=!flag;
		}
        Map<Long, Integer> map=new HashMap<Long, Integer>();
        StringBuffer sb=new StringBuffer();
        sb.append(String.valueOf(n/d)).append(".");
        n%=d;
        int i=1;
        map.put(n, i);
        while (true) {
        	n*=10;
        	sb.append(String.valueOf(n/d));
        	n%=d;
        	if (n==0) {
				return flag?sb.toString():"-"+sb.toString();
			}
        	i++;
        	if (map.get(n)==null) {
        		map.put(n, i);
			}else {
				String str=sb.toString();
				String circle=str.substring(str.length()-(i-Integer.valueOf(map.get(n))), str.length());
				String answer=str.substring(0,str.length()-(i-Integer.valueOf(map.get(n))))+"("+circle+")";
				return flag?answer:"-"+answer;
			}
		}
    }
}