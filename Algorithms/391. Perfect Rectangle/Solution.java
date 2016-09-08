public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int sumArea=0;
        Set<String> points=new HashSet<String>();
        for (int i = 0; i < rectangles.length; i++) {
            sumArea+=(rectangles[i][3]-rectangles[i][1])*(rectangles[i][2]-rectangles[i][0]);
            for (int j = 0; j < 4; j++) {
                String testPoint=rectangles[i][j/2*2]+","+rectangles[i][j%2*2+1];
                if (points.contains(testPoint)) {
                    points.remove(testPoint);
                }else{
                    points.add(testPoint);
                }
            }
        }
        if (points.size()!=4) {
            return false;
        }
        Integer[] last=new Integer[4];
        for (String point : points) {
            Integer x=new Integer(point.split(",")[0]);
            Integer y=new Integer(point.split(",")[1]);
            last[last[0]!=null&&!last[0].equals(x)?2:0]=x;
            last[last[1]!=null&&!last[1].equals(y)?3:1]=y;
        }
        return sumArea==Math.abs((last[3]-last[1])*(last[2]-last[0]));
    }
}