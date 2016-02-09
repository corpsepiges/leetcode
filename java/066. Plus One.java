public class Solution {
    public int[] plusOne(int[] digits) {
    	int i=digits.length-1;
        boolean flag= false;
        do {
			if (digits[i]<9) {
				digits[i]+=1;
				flag=false;
			}else {
				digits[i]=0;
				flag=true;
			}
			i--;
		} while (flag&&i>=0);
        if (flag) {
			int[] answer=new int[digits.length+1];
			answer[0]=1;
			return answer;
		}else {
			return digits;
		}
    }
}