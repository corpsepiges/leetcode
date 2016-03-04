public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int l1=v1.length;
        int l2=v2.length;
        for (int i = 0; i < Math.min(l1, l2); i++) {
			if (Integer.valueOf(v1[i])<Integer.valueOf(v2[i])) {
				return -1;
			}else if (Integer.valueOf(v1[i])>Integer.valueOf(v2[i])) {
				return 1;
			}
		}
        if (l1==l2) {
			return 0;
		}else if (l1>l2) {
			for (int i = l2; i <l1; i++) {
				if (Integer.parseInt(v1[i])!=0) {
					return 1;
				}
			}
			return 0;
		}else {
			for (int i = l1; i < l2; i++) {
				if (Integer.parseInt(v2[i])!=0) {
					return -1;
				}
			}
			return 0;
		}
    }
}