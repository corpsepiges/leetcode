public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length()==0) {
			return s.length()==0;
		}
        if (s.length()==0) {
			if (p.length()%2!=0) {
				return false;
			}
			char[] c=p.toCharArray();
			for (int i = 1; i < c.length; i+=2) {
				if (c[i]!=&#39;*&#39;) {
					return false;
				}
			}
			return true;
		}
        int pl=p.length();
        int sl=s.length();
        String ep=p.substring(pl-1,pl);
        if (ep.equals("*")) {
			if (p.substring(pl-2,pl-1).equals(".")) {
				for (int i = sl-1; i >=0-1; i--) {
					if (isMatch(s.substring(0, i+1),p.substring(0, pl-2))) {
						return true;
					}
				}
				return false;
			}else {
				String k=p.substring(pl-2,pl-1);
				for (int i = sl-1; i >=0; i--) {
					String t=s.substring(i,i+1);
					if (t.equals(k)) {
						if (isMatch(s.substring(0, i+1),p.substring(0, pl-2))) {
							return true;
						}
					}else {
						return isMatch(s.substring(0, i+1),p.substring(0, pl-2));
					}
				}
				return isMatch("",p.substring(0, pl-2));
			}
		}else if(ep.equals(".")){
			return isMatch(s.substring(0, sl-1),p.substring(0, pl-1));
		}else {
			String es=s.substring(sl-1,sl);
			if (ep.equals(es)) {
				return isMatch(s.substring(0, sl-1),p.substring(0, pl-1));
			}
			return false;
		}
    }
}