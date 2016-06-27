public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        return z==x||z==y||(z<=x+y&&z%gcd(x, y)==0);
    }
    public int gcd(int x,int y){
        return x==0?y:gcd(y%x,x);
    }
}