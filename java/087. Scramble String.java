public class Solution {
	Map<String,Boolean> map=new HashMap<String, Boolean>();
    public boolean isScramble(String s1, String s2) {
    	if (map.get(s1+","+s2)!=null) {
			return map.get(s1+","+s2);
		}
    	int length=s1.length();
    	if (length!=s2.length()) {
    	    map.put(s1+","+s2, false);
			return false;
		}
    	boolean flag=false;
    	if (length==1) {
    	    flag=s1.equals(s2);
    	    map.put(s1+","+s2, flag);
    		return flag;
		}
    	for (int i = 1; i <length&&!flag; i++) {
    		String s1b=s1.substring(0,i);
    		String s1e=s1.substring(i,length);
    		String s2b=s2.substring(0,i);
    		String s2e=s2.substring(i,length);
    		String ns2b=s2.substring(0,length-i);
    		String ns2e=s2.substring(length-i,length);
    		flag=(isScramble(s1b,s2b)&&isScramble(s1e,s2e))||(isScramble(s1b,ns2e)&&isScramble(s1e,ns2b));
		}
    	map.put(s1+","+s2, flag);
    	return flag; 
    }
}