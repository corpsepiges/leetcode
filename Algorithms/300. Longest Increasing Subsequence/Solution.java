public class Solution {
	int[] ans;
	int length=0;
    public int lengthOfLIS(int[] nums) {
    	ans=new int[nums.length];
    	for (int i = 0; i < nums.length; i++) {
			f(nums[i]);
		}
    	return length;
    }
    public void f(int n){
    	if (length==0||ans[length-1]<n) {
			ans[length]=n;
			length++;
		}else {
			int s=0;
			int e=length-1;
			int m=(s+e)/2;
			while (e-s>1) {
			    if(ans[m]==n){
					return;
				}
				if (ans[m]>n) {
					e=m;
				}else {
					s=m;
				}
				m=(s+e)/2;
			}
			if (ans[s]>n) {
				ans[s]=n;
			}else {
				ans[e]=n;
			}
		}
    }
}