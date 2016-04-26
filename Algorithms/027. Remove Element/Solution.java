public class Solution {
    public int removeElement(int[] nums, int val) {
       int end=nums.length;
    int k=0;
    for (int i = 0; i < end; i++) {
        if (nums[i]==val) {
            for (int j = i; j < end-1; j++) {
                k=nums[j];
                nums[j]=nums[j+1];
                nums[j+1]=k;
            }
            end--;
            i--;
        }
    }
    return end;
    }
}