public class Solution {
    public int uniquePaths(int m, int n) {
        if (m==1||n==1) {
            return 1;
        }
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i = 0; i < m; i++) {
            map.put(i, 1);
        }
        for (int i = 1; i < n-1; i++) {
            int sum=0;
            for (int j = m-1; j >=0; j--) {
                sum+=map.get(j);
            }
            int k=map.get(m-1);
            for (int j = m-1; j >=0; j--) {
                map.put(j, sum);
                sum-=k;
                if (j>1) {
                    k=map.get(j-1);
                }
            }
        }
        int sum=0;
        for (int i = 0; i < m; i++) {
            sum+=map.get(i);
        }
        return sum;
    }
}