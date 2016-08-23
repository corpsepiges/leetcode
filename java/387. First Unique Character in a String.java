public class Solution {
    public int firstUniqChar(String s) {
        char[] cs=s.toCharArray();
        List<Character> list=new ArrayList<Character>();
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        for (int i = 0; i < cs.length; i++) {
            Character c=cs[i];
            if (map.containsKey(c)) {
                list.remove(c);
            }else{
                list.add(c);
                map.put(c,i);
            }
        }
        return list.size()==0?-1:map.get(list.get(0));
    }
}