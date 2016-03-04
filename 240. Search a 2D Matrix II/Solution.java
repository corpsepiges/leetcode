public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int x=matrix.length-1;
    	int y=0;
    	while (x>=0&&y<matrix[x].length) {
			if (matrix[x][y]==target) {
				return true;
			}
			if (matrix[x][y]>target) {
				x--;
			}else {
				y++;
			}
		}
    	return false;
    }
}