public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        Boolean flag=null;
        int ans=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=nums[i-1]&&(flag==null||flag==nums[i]>nums[i-1])) {
                flag=nums[i]<nums[i-1];
                ans++;
            }
        }
        return ans;
    }
}