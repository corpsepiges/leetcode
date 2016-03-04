public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs=str.split(" ");
        if (pattern.length()!=strs.length) {
			return false;
		}
        //正向匹配
        Map<String,String> m=new HashMap<String, String>();
        //反向匹配
        Map<String,String> n=new HashMap<String, String>();
        for (int i = 0; i < strs.length; i++) {
			String p=pattern.substring(i,i+1);
			if (m.get(p)==null) {
				m.put(p, strs[i]);
			}else if (!m.get(p).equals(strs[i])) {
				return false;
			}
			if (n.get(strs[i])==null) {
				n.put(strs[i], p);
			}else if (!n.get(strs[i]).equals(p)) {
				return false;
			}
		}
        return true;
    }
}