public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length()>t.length()) {
            return isOneEditDistance(t, s);
        }
        if (s.length()+1<t.length()) {
            return false;
        }
        char[] cs=s.toCharArray();
        char[] ct=t.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i]!=ct[i]) {
                if (s.length()==t.length()) {
                    return s.substring(i+1,s.length()).equals(t.substring(i+1,t.length()));
                }else{
                    return s.substring(i,s.length()).equals(t.substring(i+1,t.length()));
                }
            }
        }
        return s.length()!=t.length();
    }
}