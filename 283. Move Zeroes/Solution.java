public class Solution {
    public void moveZeroes(int[] nums) {
    	if (nums!=null&&nums.length!=1) {
    		int b=-1;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i]==0) {
					b=i;
					break;
				}
			}
			if (b!=nums.length-1&&b!=-1) {
				for (int i = b+1; i < nums.length; i++) {
					int k=nums[i];
					if (k!=0) {
						nums[b]=k;
						nums[i]=0;
						b++;
					}
				}
			}
		}
    }
}