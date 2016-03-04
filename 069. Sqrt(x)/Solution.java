public class Solution {
    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        if(x==1){
            return 1;
        }
        int s=1;
	for (int i = 0; i <20; i++) {
		s=(x/s)/2+s/2;
	}
	int k=0;
	int answer=0;
	for (int i = -30; i < 30; i++) {
		k=s+i;
		if (k*k>0&&k*k<=x) {
			answer=k;
		}
	}
	return answer;
    }
}