public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int n = x;
        int a = 0;
        int p = 1;
        while (x != 0) {
            x /= 10;
            a++;
            p *= 10;
            if (a==1) {
                p/=10;
            }
        }
        int b = a / 2;
        if (b == 0) {
            return true;
        }

        for (int i = 0; i < b; i++) {
            int begin = n / p;
            int end = n % 10;
            if (begin != end) {
                return false;
            } else {
                n = n - (begin * p);
                p /= 100;
                n = (n - end) / 10;
            }
        }
        return true;
    }
}