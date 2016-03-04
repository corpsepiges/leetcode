public class Solution {
	int ans=Integer.MIN_VALUE;
    public int threeSumClosest(int[] nums, int target) {
    	Arrays.sort(nums);  
    	int length=nums.length;  
        for (int i = 0; i < length-2; i++) {  
            if (i==0||nums[i]!=nums[i-1]) {  
                f(nums,i,i+1,length-1,target);
                if (ans==0) {
					return target;
				}
            }  
        }  
        return target+ans;  
    }
    public void f(int[] nums,int s,int m,int e,int target){  
        while (m<e) {  
            int res=nums[s]+nums[m]+nums[e]-target;  
            if (res==0) {  
                ans=0;
                break;
            }else if(res<0) {
                m++;  
            }else {
                e--;  
            }
            if (ans/res!=0) {
				ans=res;
			}
        }  
    };  
}