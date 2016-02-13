public class Solution {
    public int romanToInt(String s) {
        	int a;
	int b;
	int c;
	int d;
	String sa="";
	String sb="";
	String sc="";
	String sd="";
	String flag="千";
	for (int i = 0; i < s.length(); i++) {
		String t=s.substring(i,i+1);
		if (flag.equals("千")) {
			if(t.equals("M")){
				sa+=t;
				continue;
			}else {
				flag="百";
			}
		}
		if (flag.equals("百")) {
			if (t.equals("C")||t.equals("D")||t.equals("M")) {
				sb+=t;
				continue;
			}else {
				flag="十";
			}
		}
		if (flag.equals("十")) {
			if (t.equals("X")||t.equals("L")||t.equals("C")) {
				sc+=t;
				continue;
			}else {
				flag="个";
			}
		}
		if (flag.equals("个")) {
			if (t.equals("I")||t.equals("V")||t.equals("X")) {
				sd+=t;
				continue;
			}
		}
		
	}
	a=sa.length();
	if (sb.length()==0) {
		b=0;
	}else if (sb.contains("M")) {
		b=9;
	}else if(sb.substring(0,1).equals("D")){
		b=5+sb.length()-1;
	}else if (sb.contains("D")) {
		b=4;
	}else {
		b=sb.length();
	}
	if (sc.length()==0) {
		c=0;
	}else if (sc.contains("C")) {
		c=9;
	}else if(sc.substring(0,1).equals("L")){
		c=5+sc.length()-1;
	}else if (sc.contains("L")) {
		c=4;
	}else {
		c=sc.length();
	}
	if (sd.length()==0) {
		d=0;
	}else if (sd.contains("X")) {
		d=9;
	}else if(sd.substring(0,1).equals("V")){
		d=5+sd.length()-1;
	}else if (sd.contains("V")) {
		d=4;
	}else {
		d=sd.length();
	}
	return 1000*a+100*b+10*c+d;
    }
}