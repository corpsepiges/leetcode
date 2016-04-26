public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]<nums[j]) {
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        int[] n=new int[nums.length];
        int sum=1;
        for (int i = n.length-1; i >=0;i--) {
            n[i]=sum;
            sum*=2;
        }
        List<List<Integer>> answer=new ArrayList<List<Integer>>();
        for (int i = 0; i < sum; i++) {
            List<Integer> list=new ArrayList<Integer>();
            for (int j = nums.length-1; j >=0 ; j--) {
                if ((i/n[j])%2==1) {
                    list.add(nums[j]);
                }
            }
            answer.add(list);
        }
        Map<List<Integer>, Integer> map=new HashMap<List<Integer>, Integer>();
        for (int i = 0; i < answer.size(); i++) {
            if (map.get(answer.get(i))==null) {
                map.put(answer.get(i), 1);
            }else {
                answer.remove(i);
                i--;
            }
        }
        return answer;
    }
}