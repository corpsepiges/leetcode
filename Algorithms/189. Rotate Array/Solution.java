public class Solution {
    public void rotate(int[] nums, int k) {
    	k=k%nums.length;
        List<Integer> list=new ArrayList<Integer>();
        for (int i = nums.length-k; i < nums.length; i++) {
			list.add(nums[i]);
		}
        for (int i = nums.length-1; i >=k; i--) {
			nums[i]=nums[i-k];
		}
        for (int i = 0; i < k; i++) {
			nums[i]=list.get(i);
		}
    }
}