public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer=0;
        Map<String,Integer> map=new HashMap<String, Integer>();
        List<String> list=new LinkedList<String>();
        for (int i = 0; i < s.length(); i++) {
            String k=s.substring(i, i+1);
            if (map.get(k) != null) {
                int n=map.get(k)-map.get(list.get(0))+1;
                for (int j = 0; j < n; j++) {
                    map.remove(list.get(0));
                    list.remove(0);
                }
            }
            map.put(k, i);
            list.add(k);
            if (list.size()>answer) {
                answer=list.size();
            }
        }
        return answer;
    }
}