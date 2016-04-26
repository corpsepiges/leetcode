public class Solution {
    public int findMin(int[] nums) {
        int a=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]<a) {
                a=nums[i];
            }
        }
        return a;
    }
}