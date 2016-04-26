public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        String[] newStrs=new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            char[] c=strs[i].toCharArray();
            Arrays.sort(c);
            newStrs[i]=String.valueOf(c);
        }
        Map<String,List<Integer>> map=new HashMap<String, List<Integer>>();
        for (int i = 0; i < newStrs.length; i++) {
            String str=newStrs[i];
            List<Integer> list=null;
            if (map.get(str)==null) {
                list=new ArrayList<Integer>();
            }else {
                list=map.get(str);
            }
            list.add(i);
            map.put(str, list);
        }
        List<List<String>> ans=new ArrayList<List<String>>();
        Set<String> keySet = map.keySet();
        for (String s:keySet) {
            List<Integer> l=map.get(s);
            List<String> list=new ArrayList<String>();
            for (int i = 0; i < l.size(); i++) {
                list.add(strs[l.get(i)]);
            }
            ans.add(list);
        }
        return ans;
    }
}