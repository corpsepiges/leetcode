public class Solution {
    public int maxRotateFunction(int[] A) {
        int length=A.length;
        if (length==0) {
            return 0;
        }
        int[] F=new int[length];
        int sum=0;
        for (int i = 0; i < length; i++) {
            F[0]+=i*A[i];
            sum+=A[i];
        }
        int max=F[0];
        for (int i = 1; i < length; i++) {
            F[i]=F[i-1]+sum-length*A[length-i];
            if (F[i]>max) {
                max=F[i];
            }
        }
        return max;
    }
}