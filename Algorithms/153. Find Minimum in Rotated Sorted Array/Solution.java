public class Solution {
    public int findMin(int[] nums) {
        int begin=0;
        int end=nums.length-1;
        int half=(begin+end)/2;
        while (end-begin>1) {
            if (nums[half]>nums[begin]&&nums[half]>nums[end]) {
                begin=half;
                half=(begin+end)/2;
            }else {
                end=half;
                half=(begin+end)/2;
            }
        }
        return nums[begin]>nums[end]?nums[end]:nums[begin];
    }
}