public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m-1; i >=0; i--) {
			nums1[i+nums1.length-m]=nums1[i];
		}
        int a=nums1.length-m;
        int b=0;
        for (int i = 0; i < m+n; i++) {
        	if (a==nums1.length) {
        		nums1[i]=nums2[b];
				b++;
			}else if (b==n||nums1[a]<nums2[b]) {
				nums1[i]=nums1[a];
				a++;
			}else {
				nums1[i]=nums2[b];
				b++;
			}
			
		}
    }
}