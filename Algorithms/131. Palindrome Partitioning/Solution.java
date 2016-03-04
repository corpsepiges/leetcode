public class Solution {
	Map<String,List<List<String>>> map=new HashMap<String, List<List<String>>>();
    public List<List<String>> partition(String s) {
        if (map.get(s)!=null) {
        	return map.get(s);
		}
        List<List<String>> ans=new ArrayList<List<String>>();
        if(isPartition(s)){
        	List<String> list=new ArrayList<String>();
        	list.add(s);
        	ans.add(list);
        }
        for (int i = 0; i < s.length()-1; i++) {
			String k=s.substring(0,i+1);
			if (isPartition(k)) {
				String t=s.substring(i+1,s.length());
				List<List<String>> list=partition(t);
				for (int j = 0; j < list.size(); j++) {
					List<String> l=new ArrayList<String>();
					l.add(k);
					l.addAll(list.get(j));
					ans.add(l);
				}
 			}
		}
    	map.put(s, ans);
    	return ans;
    }
    public boolean isPartition(String s){
    	if(s.length()==1){
    		return true;
    	}
    	char[] c=s.toCharArray();
    	int length=c.length;
    	for (int i = 0; i < length/2; i++) {
			if(c[i]!=c[length-1-i]){
				return false;
			}
		}
    	return true;
    }
}