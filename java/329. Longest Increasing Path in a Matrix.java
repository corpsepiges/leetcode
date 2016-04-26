public class Solution {
    boolean[][] flag=null;
    int[][] nums=null;
    int[][] ans=null;
    int rows=0;
    int cols=0;
    public int longestIncreasingPath(int[][] matrix) {
        rows=matrix.length;
        if(rows==0){
            return 0;
        }
        cols=matrix[0].length;
        flag=new boolean[rows][cols];
        nums=matrix;
        ans=new int[rows][cols];
        int res=1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i>0&&matrix[i-1][j]>matrix[i][j])||(j>0&&matrix[i][j-1]>matrix[i][j])||(i<rows-1&&matrix[i+1][j]>matrix[i][j])||(j<cols-1&&matrix[i][j+1]>matrix[i][j])) {
                    int test=f(i, j,0);
                    if (test>res) {
                        res=test;
                    }
                }
            }
        }
        return res;
    }
    public int f(int x,int y,int d){
        int nx=x+(d%2);
        int ny=y+(d/2);
        if(nx<0||nx>=rows||ny<0||ny>=cols){
            return 0;
        }else if (d!=0&&nums[nx][ny]<=nums[x][y]) {
            return 0;
        }else if(flag[nx][ny]){
            return ans[nx][ny];
        } else {
            int res=0;
            for (int i = -2; i <=2; i++) {
                if (i!=0) {
                    int test=f(nx,ny,i);
                    if (test>res) {
                        res=test;
                    }
                }
            }
            flag[nx][ny]=true;
            ans[nx][ny]=res+1;
            return res+1;
        }
    }
}