public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int a1=0;
        int a2=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list=new ArrayList<Integer>();
        while (a1<nums1.length&&a2<nums2.length) {
            if (nums1[a1]==nums2[a2]) {
                list.add(nums1[a1]);
                a1++;
                a2++;
            }else if (nums1[a1]<nums2[a2]) {
                a1++;
            }else {
                a2++;
            }
        }
        int[] res=new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]=list.get(i);
        }
        return res;
    }
}