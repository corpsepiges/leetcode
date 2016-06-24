public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] sums=new int[row][col];
        sums[0][0]=matrix[0][0];
        for (int i = 1; i < row; i++) {
            sums[i][0]=sums[i-1][0]+matrix[i][0];
        }
        for (int j = 1; j < col; j++) {
            sums[0][j]=sums[0][j-1]+matrix[0][j];
        }
        for (int i = 1; i <row; i++) {
            for (int j = 1; j < col; j++) {
                sums[i][j]=sums[i-1][j]+sums[i][j-1]-sums[i-1][j-1]+matrix[i][j];
            }
        }
        int ans=Integer.MIN_VALUE;
        for (int si = 0; si < row; si++) {
            for (int sj = 0; sj < col; sj++) {
                for (int ei = si; ei < row; ei++) {
                    for (int ej = sj; ej < col; ej++) {
                        int test=0;
                        if (si==0&&sj==0) {
                            test=sums[ei][ej];
                        }else if(si==0){
                            test=sums[ei][ej]-sums[ei][sj-1];
                        }else if(sj==0){
                            test=sums[ei][ej]-sums[si-1][ej];
                        }else{
                            test=sums[ei][ej]-sums[si-1][ej]-sums[ei][sj-1]+sums[si-1][sj-1];
                        }
                        if (test<=k&&test>ans) {
                            ans=test;
                        }
                    }
                }
            }
        }
        return ans;
    }
}