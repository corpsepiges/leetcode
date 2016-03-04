public class Solution {
    public int search(int[] nums, int target) {
		if (nums.length==1) {
			if (nums[0]==target) {
				return 0;
			}else {
				return -1;
			}
		}
		int begin=0;
		int end=nums.length-1;
		int half=(end+begin)/2;
		while (end-begin>1) {
			int b=nums[begin];
			int h=nums[half];
			int e=nums[end];
			if (h==target) {
				return half;
			}
			if (b==target) {
				return begin;
			}
			if (e==target) {
				return end;
			}
			if (h>b) {
				if (target>h) {
					begin=half;
					half=(end+begin)/2;
				}else {
					if (target>b) {
						end=half;
						half=(end+begin)/2;
					}else {
						begin=half;
						half=(end+begin)/2;
					}
				}
			}else {
				if (target<h) {
					end=half;
					half=(end+begin)/2;
				}else {
					if (target>e) {
						end=half;
						half=(end+begin)/2;
					}else {
						begin=half;
						half=(end+begin)/2;
					}
				}
			}
		}
		if (nums[begin]==target) {
			return begin;
		}
		if (nums[end]==target) {
			return end;
		}

		return -1;
	}
}