public class Solution {
    public int missingNumber(int[] nums) {
    	int ans=nums.length;
        for (int i = 0; i < nums.length; i++) {
        	ans=ans-nums[i]+i;
		}
        return ans;
    }
}