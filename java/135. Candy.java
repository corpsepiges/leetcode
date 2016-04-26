public class Solution {
    public int candy(int[] ratings) {
        int length=ratings.length;
        int[] candies=new int[length];
        candies[0]=1;
        //从左往右扫描，如果右侧比左侧大，则给左侧多1个，否则只给1个。
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i]>ratings[i-1]) {
                candies[i]=candies[i-1]+1;
            }else {
                candies[i]=1;
            }
        }
        for (int i = length - 2; i >= 0; i--) {  
            if (ratings[i]>ratings[i+1]&&candies[i]<=candies[i+1]) {  
                candies[i] = candies[i+1]+1;  
            }  
        }
        int ans=0;
        for (int i = 0; i <length; i++) {
            ans+=candies[i];
        }
        return ans;
    }
}