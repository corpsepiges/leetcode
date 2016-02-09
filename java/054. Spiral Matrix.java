public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> list=new ArrayList<Integer>();
    	//m:行，n列
    	int mb=0;
    	int nb=0;
        int me=matrix.length;
        if (me==0) {
			return list;
		}
        int ne=matrix[0].length;
    	while (true) {
    		list=new Solution().right(matrix, mb, nb, me, ne, list);
			mb++;
			if (nb>ne-1||mb>me-1) {
				return list;
			}
			list=new Solution().low(matrix, mb, nb, me, ne, list);
			ne--;
			if (nb>ne-1||mb>me-1) {
				return list;
			}
			list=new Solution().left(matrix, mb, nb, me, ne, list);
			me--;
			if (nb>ne-1||mb>me-1) {
				return list;
			}
			list=new Solution().up(matrix, mb, nb, me, ne, list);
			nb++;
			if (nb>ne-1||mb>me-1) {
				return list;
			}
		}
    }
    public List<Integer> right(int[][] matrix,int mb,int nb,int me,int ne,List<Integer> list){
    	for (int i = nb; i < ne; i++) {
			list.add(matrix[mb][i]);
		}
    	return list;
    }
    public List<Integer> left(int[][] matrix,int mb,int nb,int me,int ne,List<Integer> list){
    	for (int i = ne-1; i >=nb; i--) {
			list.add(matrix[me-1][i]);
		}
    	return list;
    }
    public List<Integer> low(int[][] matrix,int mb,int nb,int me,int ne,List<Integer> list){
    	for (int i = mb; i < me; i++) {
			list.add(matrix[i][ne-1]);
		}
    	return list;
    }
    public List<Integer> up(int[][] matrix,int mb,int nb,int me,int ne,List<Integer> list){
    	for (int i = me-1; i >=mb; i--) {
			list.add(matrix[i][nb]);
		}
    	return list;
    }
}