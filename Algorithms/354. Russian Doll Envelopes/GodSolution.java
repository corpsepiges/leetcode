import java.util.Arrays;
import java.util.Comparator;

public class Solution {  
    public int maxEnvelopes(int[][] envelopes) {  
        if(envelopes == null || envelopes.length == 0   
           || envelopes[0] == null || envelopes[0].length != 2)  
            return 0;  
        //优先按照宽度排顺序，宽度相同时按照高度排逆序
        Comparator<int[]> c=new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[0] == arr2[0])  
                    //此处是逆序
                    return arr2[1] - arr1[1];  
                else  
                    //此处是顺序
                    return arr1[0] - arr2[0];  
            }
        };
        //排序过程
        Arrays.sort(envelopes, c);  
        int dp[] = new int[envelopes.length];  
        int len = 0;  
        for(int[] envelope : envelopes){  
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);  
            //负数表示插入位置
            if(index < 0)  
                index = -(index + 1);  
            //更新当前值，因为优先宽度顺序，高度逆序
            //所以在下一个信封的高度如果大于当前最大高度，则宽度也大于
            //如果高度不大于，则优化DP
            dp[index] = envelope[1];  
            //表示当前信封高度比DP中最后一个还大，由排序规则可知其宽度也必然大于
            if(index == len)  
                len++;  
        }  
        return len;  
    }  
}  