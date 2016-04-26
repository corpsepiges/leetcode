public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]>nums[j]) {
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        int[] n=new int[nums.length];
        int sum=1;
        for (int i = 0; i < n.length; i++) {
            n[i]=sum;
            sum*=2;
        }
        List<List<Integer>> answer=new ArrayList<List<Integer>>();
        for (int i = 0; i < sum; i++) {
            List<Integer> list=new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++) {
                if ((i/n[j])%2==1) {
                    list.add(nums[j]);
                }
            }
            answer.add(list);
        }
        return answer;
    }
}