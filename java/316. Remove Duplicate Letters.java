public class Solution {
	List<List<Integer>> totalList=new ArrayList<List<Integer>>();
	int index=-1;
    public String removeDuplicateLetters(String s) {
        if (s==null||s.length()==0) {
			return "";
		}
        char[] chars=s.toCharArray();
        for (int i = 0; i < 26; i++) {
        	List<Integer> list=new ArrayList<Integer>();
        	totalList.add(list);
		}
        for (int i = 0; i < chars.length; i++) {
			int k=chars[i]-97;
			totalList.get(k).add(i);
		}
        int count=0;
        for (int i = 0; i < 26; i++) {
			if (totalList.get(i).size()!=0) {
				count++;
			}
		}
        char[] ans=new char[count];
        for (int i = 0; i < count; i++) {
			ans[i]=f();
		}
        return String.valueOf(ans);
    }
    public char f(){
    	int min=Integer.MAX_VALUE;
    	for (int i = 0; i < 26; i++) {
    		if (totalList.get(i).size()!=0) {
				int k=totalList.get(i).get(totalList.get(i).size()-1);
				if (k<min) {
					min=k;
				}
			}
		}
    	for (int i = 0; i < 26; i++) {
    		if (totalList.get(i).size()!=0) {
    			int val=totalList.get(i).get(0);
    			if (val<=min&&val>index) {
    				totalList.set(i, new ArrayList<Integer>());
    				index=val;
    				for (int j = 0; j < 26; j++) {
						if (totalList.get(j).size()!=0) {
							List<Integer> list=totalList.get(j);
							for (int k = 0; k < list.size();) {
								if (list.get(0)<index) {
									list.remove(0);
								}else {
									break;
								}
							}
						}
					}
    				return (char)(i+97);
    			}
			}
		}
		return 0;
    }
}