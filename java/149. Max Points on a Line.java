/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length<3) {
			return points.length;
		}
        int answer=2;
    	for (int i = 0; i < points.length; i++) {
			for (int j = i+1; j < points.length; j++) {
				if((points[i].x!=points[j].x)||(points[i].y!=points[j].y)){
					int sum=0;
					for (int k = 0; k < points.length; k++) {
						if (isStraight(points[i],points[j],points[k])) {
							sum++;
						}
					}
					if (sum>answer) {
						answer=sum;
					}
				}else {
					int sum=0;
					for (int k = 0; k < points.length; k++) {
						if ((points[k].x==points[j].x)&&(points[k].y==points[j].y)) {
							sum++;
						}
					}
					if (sum>answer) {
						answer=sum;
					}
				}
			}
		}
    	return answer;
    }
    public boolean isStraight (Point a,Point b,Point c){
    	return ((b.y-c.y)*(a.x-c.x))==((a.y-c.y)*(b.x-c.x));
    }
}