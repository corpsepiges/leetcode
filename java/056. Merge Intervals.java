/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
    	//0开头，2结束，-1原地，1正常
    	Map<Integer, Integer> map=new HashMap<Integer, Integer>();
    	int sum=0;
        for (int i = 0; i <intervals.size(); i++) {
			int s=intervals.get(i).start;
			int e=intervals.get(i).end;
			if (e>sum) {
				sum=e;
			}
			if (s==e) {
				if (map.get(s)==null) {
					map.put(s, -1);
				}
			}else {
				for (int j = s; j <=e; j++) {
					if (j==s) {
						if(map.get(j)==null||map.get(j)==-1||map.get(j)==0){
							map.put(j, 0);
						}else {
							map.put(j, 1);
						}
					}else if (j==e) {
						if (map.get(j)==null||map.get(j)==-1||map.get(j)==2) {
							map.put(j, 2);
						}else {
							map.put(j, 1);
						}
					}else {
						map.put(j, 1);
					}
				}
			}
		}
        boolean flag=true;
        List<Interval> answerList=new ArrayList<Interval>();
        int s=0;
        int e=0;
        for (int i = 0; i <sum+2; i++) {
			if (flag) {
				if (map.get(i)!=null&&map.get(i)==-1) {
					answerList.add(new Interval(i,i));
				}else if (map.get(i)!=null) {
					s=i;
					flag=false;
				}
			}else {
				if (map.get(i)==null||map.get(i)==2) {
					flag=true;
					e=i;
					answerList.add(new Interval(s,e));
					s=0;
				}
			}
		}
    	return answerList;
    }
}