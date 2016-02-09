public class Solution {
    public int titleToNumber(String s) {
    	int[] a=new int[s.length()];
    	boolean flag=false;
        for (int i = s.length()-1; i>=0; i--) {
			String k=s.substring(i,i+1);
			int ik= (int)(k.toCharArray()[0])-64;
			if (flag) {
				ik++;
			}
			if (ik!=26) {
				a[s.length()-1-i]=ik;
				flag=false;
			}else {
				a[s.length()-1-i]=0;
				flag=true;
			}
		}
        int p=1;
        int sum=0;
        for (int i = 0; i < a.length; i++) {
			if (i!=0) {
				p*=26;
			}
			sum+=a[i]*p;
		}
		if (flag) {
			return sum+=p*26;
		}
    	return sum;
    }
}