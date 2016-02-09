public class Solution {
    public int searchInsert(int[] nums, int target) {
        int begin=0;
		int end=nums.length-1;
		int a=(begin+end)/2;
		if (target<nums[0]) {
			return 0;
		}
		if (target>nums[nums.length-1]) {
		return nums.length;
		}
		while (nums[a]!=target) {
			if (end-1==begin&&(nums[begin]<target&&target<nums[end])) {
				return end;
			}
			if (nums[a]>target) {
				if (end==a) {
					end--;
				}else {
					end=a;
				}
			}else {
				if (begin==a) {
					begin++;
				}else {
					begin=a;
				}
			}
			a=(begin+end)/2;
		}
			return a;
    }
}