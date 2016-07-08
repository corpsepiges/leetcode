public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int[][] ans=new int[nums1.length*nums2.length][2];
        for(int i=0;i< ans.length;i++){
            ans[i][0]=nums1[i/nums2.length];
            ans[i][1]=nums2[i%nums2.length];
        }
        Comparator<int[]> c=new Comparator<int[]>(){
            public int compare(int[] arg0,int[] arg1){
                return arg0[0]+arg0[1]-arg1[0]-arg1[1];
            }
        } ;
        Arrays.sort(ans,c);
        List<int[]> res=new ArrayList<int[]>();
        for(int i=0;i<ans.length&&i<k;i++){
            res.add(ans[i]);
        }
        return res;
    }
}