public class Solution {
    public int removeDuplicates(int[] nums) {
    	if (nums.length<3) {
			return nums.length;
		}
    	boolean flag=true;
    	int k=0;
    	int t=nums[0];
        for (int i = 1; i < nums.length; i++) {
        	t=nums[i-1];
        	nums[i-k]=nums[i];
        	if (nums[i]==t) {
        		if (flag) {
					flag=false;
				}else {
    				k++;
				}
        	}else {
        		flag=true;
			}
		}
    	return nums.length-k;
    }
}