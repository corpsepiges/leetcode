public class Solution {
    public int maximalSquare(char[][] matrix) {
    	int cross=matrix.length;
    	if (cross==0) {
			return 0;
		}
    	int vertical=matrix[0].length;
    	int max=0;
        int[][] size=new int[cross][vertical];
        for (int i = 0; i < cross; i++) {
        	size[i][0]=matrix[i][0]==&#39;1&#39;?1:0;
        	if (size[i][0]>max) {
        		max=size[i][0];
			}
		}
        for (int i = 0; i < vertical; i++) {
        	size[0][i]=matrix[0][i]==&#39;1&#39;?1:0;
        	if (size[0][i]>max) {
        		max=size[0][i];
			}
		}
        for (int i = 1; i < cross; i++) {
			for (int j = 1; j < vertical; j++) {
				size[i][j]=matrix[i][j]==&#39;1&#39;?Math.min(Math.min(size[i-1][j], size[i][j-1]), size[i-1][j-1])+1:0;
				if (size[i][j]>max) {
					max=size[i][j];
				}
			}
		} 
        return max*max;
    }
}