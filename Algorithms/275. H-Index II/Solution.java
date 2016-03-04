public class Solution {
    public int hIndex(int[] citations) {
    	if (citations.length==0) {
			return 0;
		}
        Arrays.sort(citations);
        int s=0;
        int e=citations.length-1;
        int m=(s+e)/2;
        int l=citations.length;
        while (e-s>1) {
        	if (l<citations[s]+s) {
				return l;
			}
        	if (l==citations[m]+m) {
				return l-m;
			}
        	if (l>citations[m]+m) {
				s=m;
			}else {
				e=m;
			}
        	m=(s+e)/2;
		}
        if (l>citations[e]+e) {
			return l-e-1;
		}else if(l>citations[s]+s){
			return l-e;
		}else{
		    return l-s;
		}
    }
}