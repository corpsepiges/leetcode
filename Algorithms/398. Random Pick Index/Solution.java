public class Solution {
    Random r;
    int[] nums;
    public Solution(int[] nums) {
        r=new Random();
        this.nums=nums;
    }
    public int pick(int target) {
        int index=0;
        int times=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target) {
                if (r.nextInt(++times)==0) {
                    index=i;
                }
            }
        }
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */