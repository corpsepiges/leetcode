public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length==1) {
            return 0;
        }
        int s=0;
        int e=nums.length-1;
        int m=(s+e)/2;
        while (e-s>1) {
            if (nums[m]>nums[m+1]) {
                e=m;
            }else {
                s=m;
            }
            m=(s+e)/2;
        }
        return nums[s]>nums[e]?s:e;
    }
}