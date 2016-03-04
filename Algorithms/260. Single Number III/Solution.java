public class Solution {
    public int[] singleNumber(int[] nums) {
        int x=0;
        for(int i=0;i<nums.length;i++){
            x^=nums[i];
        }
        //x的二进制形式从后往前第一个1对应的数
        int y=x-(x&(x-1));
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
            if((y&nums[i])==0){
                ans[0]^=nums[i];
            }else{
                ans[1]^=nums[i];
            }
        }
        return ans;
    }
}