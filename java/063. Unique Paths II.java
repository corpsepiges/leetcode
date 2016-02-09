public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if (obstacleGrid[0][0]==1||obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1) {
			return 0;
		}
    	Map<String,Integer> map=new HashMap<String, Integer>();
    	return f(obstacleGrid,0,0,obstacleGrid.length-1,obstacleGrid[0].length-1,map);
    }
    public int f(int[][] obstacleGrid,int x,int y,int xl,int yl,Map<String,Integer> map){
    	String coordinate=x+","+y;
    	if (x==xl&&y==yl) {
			return 1;
		}
    	if (map.get(coordinate)==null) {
			boolean xflag=(x<xl)&&(obstacleGrid[x+1][y]==0);
			boolean yflag=(y<yl)&&(obstacleGrid[x][y+1]==0);
			int value=(xflag?f(obstacleGrid,x+1,y,xl,yl,map):0)+(yflag?f(obstacleGrid,x,y+1,xl,yl,map):0);
			map.put(coordinate, value);
			return value;
		}
    	return map.get(coordinate);
    }
}