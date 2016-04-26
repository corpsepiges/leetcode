public class Solution {
    public String convertToTitle(int n) {
        List<Integer> list=new ArrayList<Integer>();
        while (n!=0) {
            list.add(n%26);
            n/=26;
        }
        boolean flag=false;
        List<Integer> l=new ArrayList<Integer>();
        for (int i = 0; i <list.size(); i++) {
            int k=list.get(i);
            if(flag){
                if (k>1) {
                    l.add(k-1);
                    flag=false;
                }else if(k==1){
                    l.add(26);
                    flag=true;
                }else {
                    l.add(25);
                    flag=true;
                }
            }else {
                if (k!=0) {
                    l.add(k);
                    flag=false;
                }
                else {
                    l.add(26);
                    flag=true;
                }
            }
        }
        int m=l.size();
        if (flag) {
            m--;
        }
        String answer="";
         for (int i = m-1; i >=0; i--) {
            int k=l.get(i);
            k+=64;
            char c=(char) k;
            String s=String.valueOf(c);
            answer+=s;
        }
        return answer;
    }
}