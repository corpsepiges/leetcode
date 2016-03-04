public class Solution {
    public String intToRoman(int num) {
      String a = "";
		String b = "";
		String c = "";
		String d = "";
		int ia = num / 1000;
		int ib = (num / 100) % 10;
		int ic = (num / 10) % 10;
		int id = num % 10;
		switch (id) {
		case 0:
			d = "";
			break;
		case 1:
			d = "I";
			break;
		case 2:
			d = "II";
			break;
		case 3:
			d = "III";
			break;
		case 4:
			d = "IV";
			break;
		case 5:
			d = "V";
			break;
		case 6:
			d = "VI";
			break;
		case 7:
			d = "VII";
			break;
		case 8:
			d = "VIII";
			break;
		case 9:
			d = "IX";
			break;
		default:
			break;
		}
		switch (ic) {
		case 0:
			c = "";
			break;
		case 1:
			c = "X";
			break;
		case 2:
			c = "XX";
			break;
		case 3:
			c = "XXX";
			break;
		case 4:
			c = "XL";
			break;
		case 5:
			c = "L";
			break;
		case 6:
			c = "LX";
			break;
		case 7:
			c = "LXX";
			break;
		case 8:
			c = "LXXX";
			break;
		case 9:
			c = "XC";
			break;
		default:
			break;
		}
			switch (ib) {
		case 0:
			b = "";
			break;
		case 1:
			b = "C";
			break;
		case 2:
			b = "CC";
			break;
		case 3:
			b = "CCC";
			break;
		case 4:
			b = "CD";
			break;
		case 5:
			b = "D";
			break;
		case 6:
			b = "DC";
			break;
		case 7:
			b = "DCC";
			break;
		case 8:
			b = "DCCC";
			break;
		case 9:
			b = "CM";
			break;
		default:
			break;
		}
		switch (ia) {
		case 0:
			a = "";
			break;
		case 1:
			a = "M";
			break;
		case 2:
			a = "MM";
			break;
		case 3:
			a = "MMM";
			break;
		default:
			break;
		}
		return a+b+c+d;
    }
}