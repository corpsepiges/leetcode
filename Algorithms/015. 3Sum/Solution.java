public class Solution {
	List<List<Integer>> ans=new ArrayList<List<Integer>>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
    	if (nums.length<3) {
			return ans;
		}
    	int length=nums.length;
    	for (int i = 0; i < length-2; i++) {
    		if (i==0||nums[i]!=nums[i-1]) {
    			f(nums,nums[i],i+1,length-1);
			}
		}
    	return ans;
    }
    public void f(int[] nums,int target,int s,int e){
    	while (s<e) {
    		int res=nums[s]+nums[e]+target;
			if (res==0) {
				List<Integer> list=new ArrayList<Integer>();
				list.add(target);
				list.add(nums[s]);
				list.add(nums[e]);
				ans.add(list);
				while (s<e&&nums[s] == nums[s+1]) {
					s++;
				}
				while (s<e&&nums[e] == nums[e-1]) {
					e--;
				}
				s++;
				e--;
			}else if(res<0) {
				s++;
			}else {
				e--;
			}
		}
    };
}