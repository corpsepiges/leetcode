public class Solution {
    public char findTheDifference(String s, String t) {
        int length=s.length();
        char[] cs=s.toCharArray();
        char[] ct=t.toCharArray();
        int[] nums=new int[26];
        nums[ct[length]-'a']++;
        for (int i = 0; i < length; i++) {
            nums[cs[i]-'a']--;
            nums[ct[i]-'a']++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) {
                return (char) ('a'+i);
            }
        }
        return 0;
    }
}