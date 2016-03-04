public class Solution {
    public int maxProduct(int[] nums) {
        List<List<Integer>> totalList=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        boolean flag=false;
        for (int i = 0; i < nums.length; i++) {
			if (nums[i]!=0) {
				list.add(nums[i]);
			}else {
			    flag=true;
				if (list.size()!=0) {
					totalList.add(list);
				}
				list=new ArrayList<Integer>();
			}
		}
        if (list.size()!=0) {
			totalList.add(list);
		}
        if (totalList.size()==0) {
			return 0;
		}
        int ans=Integer.MIN_VALUE;
    	for (int i = 0; i < totalList.size(); i++) {
    		int f=max(totalList.get(i));
			if (f>ans) {
				ans=f;
			}
		}
		if (flag&&ans<0) {
			return 0;
		}
    	return ans;
    }
    
    public int max(List<Integer> list){ 
    	if (list.size()==1) {
			return list.get(0);
		}
    	int s=-1;
    	int e=-1;
    	int sum=0;
    	for (int i = 0; i <list.size(); i++) {
			if (list.get(i)<0) {
				if (s<0) {
					s=i;
				}else {
					e=i;
				}
				sum++;
			}
		}
    	if (e==-1) {
			e=s;
		}
    	int ans=1;
    	for (int i = 0; i <list.size(); i++) {
			ans*=list.get(i);
		}
    	if (sum%2==0) {
			return ans;
		}
    	int left=1;
    	for (int i = 0; i <=s; i++) {
			left*=list.get(i);
		}
    	int right=1;
    	for (int i = list.size()-1; i >=e; i--) {
			right*=list.get(i);
		}
    	return left>right?(ans/left):(ans/right);
    }
}