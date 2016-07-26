public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] ans=new int[target+1];
        for (int i = 1; i < ans.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j]<i) {
                    ans[i]+=ans[i-nums[j]];
                }else{
                    ans[i]+=i/nums[j];
                    break;
                }
            }
        }
        return ans[target];
    }
}