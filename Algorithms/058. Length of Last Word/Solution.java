public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length()==0) {
            return 0;
        }
        int e=-1;
        for (int i = s.length()-1; i >=0; i--) {
            if (!s.substring(i,i+1).equals(" ")) {
                e=i;
                break;
            }
        }
        if (e==-1) {
            return 0;
        }
        int b=-1;
        for (int i = e-1; i >=0; i--) {
            if (s.substring(i,i+1).equals(" ")) {
                b=i;
                break;
            }
        }
        System.out.println("b="+b);
        return b==-1?e+1:e-b;
    }
}