public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) {
            return "";
        }
        if (strs.length==1) {
            return strs[0];
        }
        int n=0;
        if (strs[0].length()<strs[1].length()) {
            n=strs[0].length();
        }else {
            n=strs[1].length();
        }
        String answer="";
        for (int i = 0; i < n; i++) {
            String k0=strs[0].substring(i,i+1);
            String k1=strs[1].substring(i,i+1);
            if (k0.equals(k1)) {
                answer+=k0;
            }else {
                break;
            }
        }
        if (strs.length==2) {
            return answer;
        }
        for (int i = 2; i < strs.length; i++) {
            if (answer.length()==0) {
                return "";
            }
            int length=0;
            String k="";
            if (strs[i].length()<answer.length()) {
                length=strs[i].length();
            }else {
                length=answer.length();
            }
            while (!answer.substring(0, length).equals(strs[i].substring(0, length))) {
                length--;
            }
            answer=answer.substring(0,length);
        }
        return answer;
    
        
    }
}