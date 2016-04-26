public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        return f(s,wordDict,new HashMap<String, Boolean>());
    }
    public boolean f(String s, Set<String> wordDict,Map<String, Boolean> map){
        if (s==null||s.length()==0) {
            return true;
        }
        if (map.get(s)!=null) {
            return map.get(s);
        }else {
            for (int i = 0; i < s.length(); i++) {
                String str=s.substring(0,i+1);
                boolean flag=false;
                for (String test : wordDict) {
                    if (str.equals(test)) {
                        flag=true;
                        if (f(s.substring(i+1,s.length()),wordDict,map)) {
                            return true;
                        }
                    }
                }
                map.put(str, flag);
            }
            return false;
        }
    }
}