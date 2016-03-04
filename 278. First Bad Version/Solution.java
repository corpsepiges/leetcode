/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(isBadVersion(1)){
            return 1;
        }
        if(!isBadVersion(n-1)){
            return n;
        }
        int s=0;
        int e=n;
        int t=s/2+e/2+(s%2+e%2)/2;
        while(!(!isBadVersion(t)&&isBadVersion(t+1))){
            if(isBadVersion(t)){
                e=t;
            }else{
                s=t;
            }
               t=s/2+e/2+(s%2+e%2)/2;
        }
        return t+1;
    }
}