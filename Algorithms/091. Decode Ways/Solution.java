public class Solution {
    public int numDecodings(String s) {
    	if (s.length()==0) {
			return 0;
		}
        Map<String,Integer> map=new HashMap<String, Integer>();
        return f(s,map);
    }
    public int f(String s,Map<String,Integer> map){
    	if (s.length()==0) {
			return 1;
		}
    	if (map.get(s)==null) {
    		int length=s.length();
    		int one=-1;
    		if (length>=1) {
    			one=Integer.parseInt(s.substring(0,1));
			}
    		int two=-1;
    		if (length>=2) {
    			two=Integer.parseInt(s.substring(0,2));
			}
			int value=(one>0?f(s.substring(1,s.length()),map):0)+((one>0&&two>0&&two<27)?f(s.substring(2,s.length()),map):0);
			map.put(s, value);
			return value;
		}
    	return map.get(s);
    }
}