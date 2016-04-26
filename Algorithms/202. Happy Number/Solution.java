public class Solution {
    public boolean isHappy(int n) {
        String s=String.valueOf(n);
        Map<String, String> map=new HashMap<String, String>();
        map.put(s, "存在");
        int sum=0;
        while (true) {
            for (int i = 0; i < s.length(); i++) {
                int k=Integer.parseInt(s.substring(i,i+1));
                sum+=k*k;
            }
            if (sum==1) {
                return true;
            }
            if (map.get(String.valueOf(sum))!=null) {
                return false;
            }else {
                s=String.valueOf(sum);
                map.put(s, "存在");
                sum=0;
            }
            
        }
    }
}