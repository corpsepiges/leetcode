public class Solution {
    int[] nums;
    int[] sums;
    int l;
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        this.nums=nums;
        this.l=nums.length;
        this.sums=new int[l];
        sums[0]=nums[0];
        for (int i = 1; i < l; i++) {
            sums[i]=sums[i-1]+nums[i];
        }
        if (sums[l-1]%2==1) {
            return false;
        }
        return canHalf(l-1, sums[l-1]/2);
    }
    public boolean canHalf(int index,int test){
        if (test==0) {
            return true;
        }
        if (test<0) {
            return false;
        }
        for (int i = index; i >=0; i--) {
            if (sums[i]<test) {
                return false;
            }else if (sums[i]==test) {
                return true;
            }else{
                if (canHalf(i-1, test-nums[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}