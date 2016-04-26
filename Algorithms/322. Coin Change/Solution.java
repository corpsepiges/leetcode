public class Solution {
    int[] array;
    int minValue;
    Map<Integer,Integer> map=new HashMap<Integer, Integer>();
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        minValue=coins[0];
        array=coins;
        return f(amount);
    }
    public int f(int amount){
        if (map.get(amount)!=null) {
            return map.get(amount);
        }
        if (amount==0) {
            return 0;
        }
        if (amount<minValue) {
            return -1;
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            int v=f(amount-array[i]);
            if (v!=-1&&v<min) {
                min=v;
            }
        }
        int ans=0;
        if (min==Integer.MAX_VALUE) {
            ans=-1;
        }else{
            ans=1+min;
        }
        map.put(amount,ans);
        return ans;
    }
}