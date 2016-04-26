public class Solution {
    public void sortColors(int[] nums) {
    int t=0;
    int b=0;
    int e=nums.length-1;
    boolean flag=true;
    for (int i = 0; i < nums.length; i++) {
            if (flag) {
                if (nums[b]!=0) {
                    t=b;
                    flag=false;
                }else {
                    t++;
                }
                b++;
            }else {
                if (nums[e]==0) {
                    nums[e]=nums[t];
                    nums[t]=0;
                    flag=true;
                    t++;
                }
                e--;
            }
    }
    b=t;
    e=nums.length-1;
    flag=true;
     for (int i = t; i < nums.length; i++) {
            if (flag) {
                if (nums[b]!=1) {
                    t=b;
                    flag=false;
                }
                b++;
            }else {
                if (nums[e]==1) {
                    nums[e]=nums[t];
                    nums[t]=1;
                    flag=true;
                }
                e--;
            }
    }
    
        
    }
}