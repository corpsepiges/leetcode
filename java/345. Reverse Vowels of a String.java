public class Solution {
    public String reverseVowels(String s) {
        char[] cs=s.toCharArray();
        int i=0;
        int j=cs.length-1;
        while (i<j) {
			while (i<j&&cs[i]!=65&&cs[i]!=69&&cs[i]!=73&&cs[i]!=79&&cs[i]!=85&&cs[i]!=97&&cs[i]!=101&&cs[i]!=105&&cs[i]!=111&&cs[i]!=117) {
				i++;
			}
			while (i<j&&cs[j]!=65&&cs[j]!=69&&cs[j]!=73&&cs[j]!=79&&cs[j]!=85&&cs[j]!=97&&cs[j]!=101&&cs[j]!=105&&cs[j]!=111&&cs[j]!=117) {
				j--;
			}
			if (i<j) {
				char c=cs[i];
				cs[i]=cs[j];
				cs[j]=c;
				i++;
				j--;
			}
		}
        return String.valueOf(cs);
    }
}