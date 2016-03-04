public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length()!=t.length()) {
			return false;
		}
        Map<String,Integer> sMap=new HashMap<String, Integer>();
        Map<String,Integer> tMap=new HashMap<String, Integer>();
        for (int i = 0; i < s.length(); i++) {
			String sk=s.substring(i,i+1);
			String tk=t.substring(i,i+1);
			if ((sMap.get(sk)==null)!=((tMap.get(tk)==null))) {
				return false;
			}else if (sMap.get(sk)==null) {
				sMap.put(sk, i);
				tMap.put(tk, i);
			}else if(!sMap.get(sk).equals(tMap.get(tk))){
				return false;
			}else {
				sMap.put(sk, i);
				tMap.put(tk, i);
			}
		}
        return true;
    }
}