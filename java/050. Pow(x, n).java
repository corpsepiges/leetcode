public class Solution {
    public double myPow(double x, int n) {
    	if (n==0) {
			return 1.0;
		}
    	boolean flag=true;
    	if (n<0) {
			n=0-n;
			flag=false;
		}
    	boolean slag=true;
    	if (x<0) {
			x=0-x;
			if (n%2!=0) {
				slag=false;
			}
		}
    	if (x==1.0) {
			return slag?1.0:-1.0;
		}
    	double answer=1.0;
        for (int i = 0; i < n; i++) {
        	answer*=x;
        	if (answer==0.0) {
				return answer;
			}
		}
    	return flag?(slag?answer:-answer):(slag?1/answer:-1/answer);
    }
}