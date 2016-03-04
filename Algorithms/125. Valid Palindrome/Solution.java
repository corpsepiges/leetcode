public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length()<=1) {
			return true;
		}
    	char[] c=s.toCharArray();
    	char[] nc=new char[c.length];
    	int a=0;
    	for (int i = 0; i < c.length; i++) {
			if ((c[i]>96&&c[i]<123)||(c[i]>47&&c[i]<58)) {
				nc[a]=c[i];
				a++;
			}
			if (c[i]>64&&c[i]<91) {
				nc[a]=(char) (c[i]+32);
				a++;
			}
		}
    	for (int i = 0; i < a/2; i++) {
			if (nc[i]!=nc[a-i-1]) {
				return false;
			}
		}
    	return true;
    }
}