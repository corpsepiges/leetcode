public class Solution {
    public boolean isValid(String s) {
    String ns="";
    for (int i = 0; i <s.length(); i++) {
        String k=s.substring(i,i+1);
        if (k.equals("{")) {
            ns+=k;
            continue;
        }
        if (k.equals("[")) {
            ns+=k;
            continue;
        }
        if (k.equals("(")) {
            ns+=k;
            continue;
        }
        if (k.equals("}")) {
            if (ns.length()>0&&ns.substring(ns.length()-1, ns.length()).equals("{")) {
                ns=ns.substring(0, ns.length()-1);
                continue;
            }else {
                return false;    
            }
        }
        if (k.equals("]")) {
            if (ns.length()>0&&ns.substring(ns.length()-1, ns.length()).equals("[")) {
                ns=ns.substring(0, ns.length()-1);
                continue;
            }else {
                return false;    
            }
        }
        if (k.equals(")")) {
            if (ns.length()>0&&ns.substring(ns.length()-1, ns.length()).equals("(")) {
                ns=ns.substring(0, ns.length()-1);
                continue;
            }else {
                return false;    
            }
        }
    }
    if (ns.length()!=0) {
        return false;
    }else {
        return true;
    }
}
}