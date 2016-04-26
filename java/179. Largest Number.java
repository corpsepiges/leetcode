public class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        int temp = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; ++j) {
                if (new Solution().compare(nums[j], nums[j + 1])) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        if (nums[nums.length - 1] == 0) {
            return "0";
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            sb.append(String.valueOf(nums[i]));
        }
        return sb.toString();
    }

    public boolean compare(int a, int b) {
        char[] ca=(String.valueOf(a)+String.valueOf(b)).toCharArray();
        char[] cb=(String.valueOf(b)+String.valueOf(a)).toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i]>cb[i]) {
                return true;
            }
            if (ca[i]<cb[i]) {
                return false;
            }
        }
        return false;
    }
}