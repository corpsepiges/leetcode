public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
       int tar=nums[0];
    int l=1;
    int end=nums.length;
    int kuang=0;
    for (int i = 1; i < end; i++) {
        if (nums[i]==tar) {
            for (int j = i; j < end-1; j++) {
                kuang=nums[j];
                nums[j]=nums[j+1];
                nums[j+1]=kuang;
            }
            end--;
            i--;
        }else {
            tar=nums[i];
            l++;
        }
    }
    return l;
    }
}