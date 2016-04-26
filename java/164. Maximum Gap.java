public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length<2) {
            return 0;
        }
        Arrays.sort(nums);
        int ans=0;
        for (int i = 1; i < nums.length; i++) {
            if (ans<(nums[i]-nums[i-1])) {
                ans=nums[i]-nums[i-1];
            }
        }
        return ans;
    }
}