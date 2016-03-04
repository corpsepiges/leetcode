public class Solution {
    public List<String> summaryRanges(int[] nums) {
    	List<String> list=new ArrayList<String>();
    	if (nums.length==0) {
			return list;
		}
        int k=0;
        if (nums.length==1) {
			list.add(""+nums[k]);
			return list;
		}
    	for (int i = 1; i < nums.length; i++) {
    		if(nums[i]==nums[i-1]+1){
    			continue;
    		}else {
    			if (i-1==k) {
    				list.add(""+nums[k]);
				}else {
					list.add(""+nums[k]+"->"+nums[i-1]);
				}
				k=i;
			}
		}
    	if (k==nums.length-1) {
    		list.add(""+nums[k]);
		}else {
			list.add(""+nums[k]+"->"+nums[nums.length-1]);
		}
    	return list;
    }
}