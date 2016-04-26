public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans=0;
        for (int i = citations.length-1; i >=0 ; i--) {
            if (citations[i]>ans) {
                ans++;
            }else {
                return ans;
            }
        }
        return ans;
    }
}