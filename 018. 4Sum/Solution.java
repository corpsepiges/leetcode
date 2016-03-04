public class Solution {
	List<List<Integer>> ans=new ArrayList<List<Integer>>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length<4) {
			return ans;
		}
    	Arrays.sort(nums);
    	int length=nums.length;
    	for (int i = 0; i <length-3; i++) {
			for (int j = length-1; j >=i+3; j--) {
				if ((i==0||nums[i]!=nums[i-1])&&(j==length-1||nums[j]!=nums[j+1])) {
					f(nums,target,i,i+1,j-1,j);
				}
			}
		}
    	return ans;
    }
    public void f(int[] nums, int target,int s,int m,int n,int e){
    	int is=nums[s];
    	int ie=nums[e];
    	while (m<n) {
			int res=is+nums[m]+nums[n]+ie-target;
			if (res==0) {
				List<Integer> list=new ArrayList<Integer>();
				list.add(is);
				list.add(nums[m]);
				list.add(nums[n]);
				list.add(ie);
				ans.add(list);
				while (m<n&&nums[m]==nums[m+1]) {
					m++;
				}
				while (m<n&&nums[n]==nums[n-1]) {
					n--;
				}
				m++;
				n--;
			}else if(res<0){
				m++;
			}else{
				n--;
			}
		}
    }
}