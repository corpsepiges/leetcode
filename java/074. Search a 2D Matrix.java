public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int begin=0;
        int end=matrix.length-1;
        int t=end/2;
        if (target<matrix[0][0]||target>matrix[matrix.length-1][matrix[matrix.length-1].length-1]) {
            return false;
        }
        while (end-begin>1) {
            if (matrix[t][0]==target) {
                return true;
            }else if (matrix[end][0]<target) {
                t=end;
                begin=end;
                break;
            }else if (matrix[t][0]>target) {
                end=t;
                t=(begin+end)/2;
            }else {
                begin=t;
                t=(begin+end)/2;
            }
        }
        if (matrix[t][0]==target||matrix[begin][0]==target||matrix[end][0]==target) {
            return true;
        }else if (matrix[t][0]>target) {
            t=t-1;
        }
        int b=0;
        int e=matrix[t].length-1;
        int tt=(b+e)/2;
        while (e-b>1) {
            if (matrix[t][tt]==target) {
                return true;
            }else if (matrix[t][tt]>target) {
                e=tt;
                tt=(b+e)/2;
            }else {
                b=tt;
                tt=(b+e)/2;
            }
        }
        if (matrix[t][b]==target||matrix[t][e]==target) {
            return true;
        }
        return false;
    }
}