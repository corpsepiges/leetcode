public class Solution {
    public int singleNumber(int[] nums) {
        int min=Integer.MIN_VALUE;
        int ans=0;
        for (int i = 0; i < 32; i++) {
            int sum=0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j]&min)!=0) {
                    sum++;
                }
                nums[j]<<=1;
            }
            ans+=sum%3;
            if (i!=31) {
                ans<<=1;
            }
        }
        return ans;
    }
}