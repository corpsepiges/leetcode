public class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n==0) {
            return 0;
        }
        int[] ans=new int[n+1];
        ans[0]=0;
        ans[1]=nums[0];
        for (int i = 2; i < n+1; i++) {
            ans[i]=Math.max(nums[i-1]+ans[i-2], ans[i-1]);
        }
        return ans[n];
    }
}