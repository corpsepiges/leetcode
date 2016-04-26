public class Solution {
    public int findDuplicate(int[] nums) {
        return f(nums,0,nums.length-1);
    }
    public int f(int[] nums,int s,int e){
        if (s==e) {
            return 0;
        }
        if (s+1==e) {
            if (nums[s]==nums[e]) {
                return nums[s];
            }
            return 0;
        }
        int m=(s+e)/2;
        int a=f(nums,s,m);
        int b=f(nums,m+1,e);
        if (a!=0) {
            return a;
        }
        if (b!=0) {
            return b;
        }
        for (int i = s; i <=m; i++) {
            for (int j = m+1; j <=e; j++) {
                if (nums[i]==nums[j]) {
                    return nums[j];
                }
            }
        }
        return 0;
    }
}