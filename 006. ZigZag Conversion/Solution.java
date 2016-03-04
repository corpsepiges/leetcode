public class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }else{
        int k=numRows*2-2;
        String[] res=new String[numRows];
		for (int i = 0; i < res.length; i++) {
			res[i]="";
		}
			int step=0;
		int j=0;
		for (int i = 0; i < s.length(); i++) {
			step++;
			if (step<=numRows) {
				j=step;
			}else {
			j=numRows-(step-numRows);
			}
			res[j-1]+=s.substring(i, i+1);
			if (step==k) {
				step=0;
			}
		}
		String result="";
		for (int i = 0; i < res.length; i++) {
			result+=res[i];
		}
		return result;
        }
    }
}