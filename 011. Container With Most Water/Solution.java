public class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int ans=(right-left)*Math.min(height[left], height[right]);
        while (right>left) {
        	int water=(right-left)*Math.min(height[left], height[right]);
        	if (water>ans) {
				ans=water;
			}
        	if (height[left]<height[right]) {
				left++;
			}else {
				right--;
			}
		}
        return ans;
    }
}