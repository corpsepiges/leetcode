public class Solution {
    public void nextPermutation(int[] nums) {
    	if (nums.length>1) {

        	int a=0;
        	for (int i = 1; i < nums.length; i++) {
    			if (nums[i]>nums[i-1]) {
    				a=i;
    			}
    		}
            for (int i = a; i < (a+nums.length)/2; i++) {
    			int k=nums[i];
    			nums[i]=nums[nums.length-i+a-1];
    			nums[nums.length-i+a-1]=k;
    		}
            if (a>0) {
            	for (int i = a; i < nums.length; i++) {
            		if (nums[a-1]<nums[i]) {
            			int k=nums[i];
            			nums[i]=nums[a-1];
            			nums[a-1]=k;
            			break;
            		}
            	}
    		}
		}
    }
}