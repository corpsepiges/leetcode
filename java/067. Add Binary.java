public class Solution {
    public String addBinary(String a, String b) {
        if (a.equals("0")) {
            return b;
        }
        if (b.equals("0")) {
            return a;
        }
        if (a.length()<b.length()) {
            return new Solution().addBinary(b, a);
        }
        int[] ia=new int[a.length()];
        for (int i = a.length()-1; i >=0; i--) {
            ia[a.length()-1-i]=Integer.parseInt(a.substring(i, i+1));
        }
        int[] ib=new int[b.length()];
        for (int i = b.length()-1; i >=0; i--) {
            ib[b.length()-1-i]=Integer.parseInt(b.substring(i, i+1));
        }
        int target=0;
        int[] ias=new int[a.length()];
        for (int i = 0; i < ia.length; i++) {
            int k=0;
            if (i<ib.length) {
                k=ia[i]+ib[i]+target;
                ias[i]=k%2;
                target=k/2;
            }else {
                k=ia[i]+target;
                ias[i]=k%2;
                target=k/2;
            }
        }
        StringBuffer sb=new StringBuffer();
        if (target==1) {
            sb.append("1");
        }
        for (int i = ias.length-1; i >=0 ; i--) {
            sb.append(""+ias[i]);
        }
        return sb.toString();
    }
}