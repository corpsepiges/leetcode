public class Solution {
    public String getHint(String secret, String guess) {
        int length=secret.length();
        if (length==0) {
            return "0A0B";
        }
        char[] cs=secret.toCharArray();
        char[] cg=guess.toCharArray();
        boolean[] f=new boolean[length];
        int a=0;
        for (int i = 0; i < length; i++) {
            boolean flag=cs[i]==cg[i];
            f[i]=flag;
            a+=flag?1:0;
        }
        boolean[] g=new boolean[length];
        int b=0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i!=j&&!g[j]&&!f[i]&&!f[j]&&cg[i]==cs[j]) {
                    b++;
                    g[j]=true;
                    break;
                }
            }
        }
        return a+"A"+b+"B";
    }
}