public class Solution {
    public int rob(int[] nums) {
        if (nums.length==0) {
			return 0;
		}
        if (nums.length==1) {
			return nums[0];
		}
        int[] dp=new int[nums.length];
        //第一家到倒数第二家
        dp[0] = nums[0];
        for (int i = 1; i < nums.length-1; i++) {
			dp[i]=Math.max(dp[i-1], (i==1?0:dp[i-2])+nums[i]);
		}
        int res=dp[nums.length-2];
        //第二家到倒数第一家
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
			dp[i]=Math.max(dp[i-1], (i==2?0:dp[i-2])+nums[i]);
		}
        return Math.max(res, dp[dp.length-1]);
    }
}