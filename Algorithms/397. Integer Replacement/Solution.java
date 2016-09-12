public class Solution {
    Map<Integer, Integer> map;
    public int integerReplacement(int n) {
        map=new HashMap<Integer,Integer>();
        map.put(1, 0);
        return f(n);
    }
    public int f(int n){
        if (map.get(n)==null) {
            if (n%2==0) {
                map.put(n, f(n/2)+1);
            }else{
                //防止n=Integer.MAX_VALUE
                map.put(n,Math.min(f(n/2+1), f(n/2))+2);
            }
        }
        return map.get(n);
    }
}