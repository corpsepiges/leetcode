public class Solution {
    public List<Integer> majorityElement(int[] nums) {
    	List<Integer> ans=new ArrayList<Integer>();
    	if (nums.length==0) {
    		return ans;
		}
    	if (nums.length==1) {
    		ans.add(nums[0]);
    		return ans;
		}
    	if (nums.length==2) {
    		ans.add(nums[0]);
    		if (nums[1]!=nums[0]) {
				ans.add(nums[1]);
			}
    		return ans;
		}
    	Arrays.sort(nums);
    	int l=nums.length/3;
        for (int i = 0; i < nums.length-l;) {
			if (nums[i+l]==nums[i]) {
				ans.add(nums[i]);
				i+=l;
			}else {
				i++;
			}
		}
        for (int i = 1; i < ans.size(); i++) {
			if (ans.get(i)==ans.get(i-1)) {
				ans.remove(i);
				i--;
			}
		}
        return ans;
    }
}