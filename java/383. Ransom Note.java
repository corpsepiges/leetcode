public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rs=new int[26];
        int[] ms=new int[26];
        char[] r=ransomNote.toCharArray();
        char[] m=magazine.toCharArray();
        for (int i = 0; i < r.length; i++) {
            rs[r[i]-'a']+=1;
        }
        for (int i = 0; i < m.length; i++) {
            ms[m[i]-'a']+=1;
        }
        for (int i = 0; i < 26; i++) {
            if (rs[i]>ms[i]) {
                return false;
            }
        }
        return true;
    }
}