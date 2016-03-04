public class Solution {
    public int minPathSum(int[][] grid) {
    	int xl=grid.length;
    	int yl=grid[0].length;
    	Map<String, Integer> map=new HashMap<String, Integer>();
    	return f(grid,0,0,xl,yl,map);
    }
    public int f(int[][] grid,int x,int y,int xl,int yl,Map<String, Integer> map){
    	String coordinate=x+","+y;
    	if (map.get(coordinate)==null) {
			if (x>=xl||y>=yl) {
				return -1;
			}else {
				int xv=f(grid,x+1,y,xl,yl,map);
				int yv=f(grid,x,y+1,xl,yl,map);
			   int v=0;
			   if (xv<0) {
					v=yv;
				}else if (yv<0) {
					v=xv;
				}else if (xv>yv){
					v=yv;
				}else {
					v=xv;
				}
				int value=grid[x][y]+(v<0?0:v);
				map.put(coordinate, value);
				return value;
			}
		}
    	return map.get(coordinate);
    }
}
