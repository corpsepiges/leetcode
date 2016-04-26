public class Solution {
    public int reverse(int x) {
        String str=String.valueOf(x);
        String r="";
        int re=0;
        if (x<0) {
            for (int i = str.length()-1; i >0 ; i--) {
                r+=str.substring(i,i+1);
            }
            r="-"+r;
        }else {
            for (int i = str.length()-1; i >-1 ; i--) {
                r+=str.substring(i,i+1);
            }
        }
            try {
            re=Integer.parseInt(r);
            
        } catch (Exception e) {
        
        }
        return re;
    }
}