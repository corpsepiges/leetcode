public class Solution {
    public boolean canJump(int[] nums) {
        int k=-1;
        int tar=-1;
        for (int i = nums.length-1; i>=0 ; i--) {
            if (k==-1&&nums[i]==0) {
                k=0;
                tar=i;
            }
            if (k==0) {
                if(tar==nums.length-1&&nums[i]>=tar-i){
                    k=-1;
                }
                if (nums[i]>tar-i) {
                    k=-1;
                }
            }
        }
        if (k==-1) {
            return true;
        }else {
            return false;
        }
    }
}