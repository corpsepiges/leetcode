public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) {
            return false;
        }
        Map<Character,Integer> smap=new HashMap<Character, Integer>();
        Map<Character,Integer> tmap=new HashMap<Character, Integer>();
        char[] cs=s.toCharArray();
        char[] ct=t.toCharArray();
        for (int i = 0; i < ct.length; i++) {
            if (smap.get(cs[i])!=null) {
                smap.put(cs[i], smap.get(cs[i])+1);
            }else {
                smap.put(cs[i], 1);
            }
            if (tmap.get(ct[i])!=null) {
                tmap.put(ct[i], tmap.get(ct[i])+1);
            }else {
                tmap.put(ct[i], 1);
            }
        }
        for (int i = 0; i < ct.length; i++) {
            if (!tmap.get(ct[i]).equals(smap.get(ct[i]))) {
                return false;
            }
        }
        return true;
    }
}