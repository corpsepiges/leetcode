public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord==null||endWord==null||wordList==null||beginWord.equals(endWord)||beginWord.length()!=endWord.length()) {
            return 0;
        }
        Map<String,List<String>> map=new HashMap<String, List<String>>();
        int count=1;
        wordList.add(beginWord);
        wordList.add(endWord);
        for (String str:wordList) {
            count++;
            List<String> list=new ArrayList<String>();
            char[] cs=str.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char k=cs[i];
                for (char j = &#39;a&#39;; j <=&#39;z&#39;; j++) {
                    if (j!=k) {
                        cs[i]=j;
                        String test=String.valueOf(cs);
                        if (wordList.contains(test)) {
                            list.add(test);
                        }
                    }
                }
                cs[i]=k;
            }
            map.put(str, list);
        }
        Map<String,Integer> test=new HashMap<String, Integer>();
        test.put(beginWord, 1);
        for (int i = 1; i < count; i++) {
            Map<String,Integer> newTest=new HashMap<String, Integer>();
            for (String str:test.keySet()) {
                List<String> list=map.get(str);
                for (int j = 0; j < list.size(); j++) {
                    String k=list.get(j);
                    if (k.equals(endWord)) {
                        return i+1;
                    }
                    if (test.get(k)==null&&newTest.get(k)==null) {
                        newTest.put(k, 1);
                    }
                }
            }
            test=newTest;
        }
        return 0;
    }
}