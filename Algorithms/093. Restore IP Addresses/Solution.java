public class Solution {
    public List<String> restoreIpAddresses(String s) {
    	List<String> answerList=new ArrayList<String>();
        for (int i = 1; i <=3; i++) {
			for (int j = 1; j <=3; j++) {
				for (int k = 1; k <=3; k++) {
					int[] a={i,j,k};
					if (i+j+k<s.length()) {
						String t=new Solution().validate(s, a);
						if (!(t.equals(""))) {
							answerList.add(t);
						}
					}
				}
			}
		}
    	return answerList;
    }
    public String validate(String s,int[] a){
    	String s4=s.substring(a[0]+a[1]+a[2],s.length());
    	if (s4.length()>3||(s4.length()>1&&s4.substring(0, 1).equals("0"))||Integer.parseInt(s4)>255) {
			return "";
		}
    	String s1=s.substring(0,a[0]);
    	String s2=s.substring(a[0],a[0]+a[1]);
    	String s3=s.substring(a[0]+a[1],a[0]+a[1]+a[2]);
    	if ((s3.length()>1&&s3.substring(0, 1).equals("0"))||(s2.length()>1&&s2.substring(0, 1).equals("0"))||(s1.length()>1&&s1.substring(0, 1).equals("0"))||Integer.parseInt(s3)>255||Integer.parseInt(s2)>255||Integer.parseInt(s1)>255) {
			return "";
		}
    	return s1+"."+s2+"."+s3+"."+s4;
    }
}