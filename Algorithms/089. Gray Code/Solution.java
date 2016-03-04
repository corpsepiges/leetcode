public class Solution {
    public List<Integer> grayCode(int n) {
    	List<Integer> ans=new ArrayList<Integer>();
    	List<String> list=new ArrayList<String>();
    	if (n==0) {
    	    ans.add(0);
			return ans;
		}
    	list.add("0");
    	list.add("1");
    	for (int i = 1; i < n; i++) {
    		List<String> newList=new ArrayList<String>();
			for (int j = 0; j < list.size(); j++) {
				newList.add("0"+list.get(j));
			}
			for (int j = list.size()-1; j >= 0 ; j--) {
				newList.add("1"+list.get(j));
			}
			list=newList;
		}
    	for (int i = 0; i < list.size(); i++) {
			ans.add(Integer.valueOf(list.get(i), 2));
		}
    	return ans;
    }
}