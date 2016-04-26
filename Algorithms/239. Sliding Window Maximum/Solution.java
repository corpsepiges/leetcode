public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0||k==0||k==1) {
            return nums;
        }
        List<Integer> maxList=new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            while (maxList.size()!=0) {
                if (maxList.get(maxList.size()-1)<nums[i]) {
                    maxList.remove(maxList.size()-1);
                }else {
                    break;
                }
            }
            maxList.add(nums[i]);
        }
        int[] ans=new int[nums.length-k+1];
        ans[0]=maxList.get(0);
        for (int i = k; i < nums.length; i++) {
            //排队出去一个
            if (nums[i-k]==maxList.get(0)) {
                maxList.remove(0);
            }
            //排队进来一个
            while (maxList.size()!=0) {
                if (maxList.get(maxList.size()-1)<nums[i]) {
                    maxList.remove(maxList.size()-1);
                }else {
                    break;
                }
            }
            maxList.add(nums[i]);
            //赋值
            ans[i-k+1]=maxList.get(0);
        }
        return ans;
    }
}