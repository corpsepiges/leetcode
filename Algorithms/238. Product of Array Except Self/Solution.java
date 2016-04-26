public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length=nums.length;
        int k=0;
        boolean flag=true;
        int product=1;
        for (int i = 0; i < length; i++) {
            if (nums[i]==0) {
                if (flag) {
                    k=i;
                    flag=false;
                }else {
                    int[] answer=new int[length];
                    for (int j = 0; j <length; j++) {
                        answer[j]=0;
                    }
                    return answer;
                }
            }else {
                product*=nums[i];
            }
        }
        int[] answer=new int[length];
        if (flag) {
            for (int i = 0; i < length; i++) {
                answer[i]=product/nums[i];
            }
        }else {
            answer[k]=product;
        }
        return answer;
    }
}