public class Solution {
    public int longestSubstring(String s, int k) {
        char[] cs=s.toCharArray();
        Map<Character, Integer> map=new HashMap<Character, Integer>();
        for (Character c:cs) {
            map.put(c, map.get(c)==null?1:map.get(c)+1);
        }
        Set<Character> cSet=new HashSet<>();
        for (Character c:map.keySet()) {
            if (map.get(c)<k) {
                cSet.add(c);
            }
        }
        if (cSet.size()==0) {
            return s.length();
        }
        Set<String> set=new HashSet<String>();
        Set<String> newSet=new HashSet<String>();
        set.add(s);
        for (Character c:cSet) {
            for (String test:set) {
                String[] strs=test.split(String.valueOf(c));
                for (String str:strs) {
                    if (str.length()>0) {
                        newSet.add(str);
                    }
                }
            }
            set.clear();
            set.addAll(newSet);
            newSet.clear();
        }
        int ans=0;
        for (String test:set) {
            int maxTest=longestSubstring(test,k);
            if (maxTest>ans) {
                ans=maxTest;
            }
        }
        return ans;
    }
}