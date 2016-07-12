public class Solution {
    public int superPow(int a, int[] b) {
        a%=1337;
        if(isZero(b)){
            return 1;
        }
        int other=b[b.length-1]%2==0?1:a;
        half(b);
        int one=superPow(a,b);
        return one*one%1337*other%1337;
    }
    public void half(int[] b){
        int tmp=0;
        for(int i=0;i<b.length;i++){
            b[i]+=tmp*10;
            tmp=b[i]%2;
            b[i]=b[i]/2;
        }
    }
    public boolean isZero(int[] b){
        for(int i=0;i<b.length;i++){
            if(b[i]!=0){
                return false;
            }
        }
        return true;
    }
}
