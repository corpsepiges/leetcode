public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length<2) {
            return nums.length;
        }
        Arrays.sort(nums);
        int sum=1;
        int length=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==nums[i-1]) {
                continue;
            }
            if (nums[i]==nums[i-1]+1) {
                sum++;
            }else {
                if (sum>length) {
                    length=sum;
                }
                sum=1;
            }
        }
        return length>sum?length:sum;
    }
}