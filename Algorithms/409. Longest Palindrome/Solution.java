public class Solution {
    public int longestPalindrome(String s) {
        int[] nums=new int[52];
        char[] cs=s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i]>=97) {
                nums[cs[i]-97+26]++;
            }else{
                nums[cs[i]-65]++;
            }
        }
        int ans=0;
        for (int i = 0; i < nums.length; i++) {
            ans+=nums[i]/2*2;
            if (ans%2==0) {
                ans+=nums[i]%2;
            }
        }
        return ans;
    }
}