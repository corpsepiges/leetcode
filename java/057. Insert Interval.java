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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int s = newInterval.start;
		int e = newInterval.end;
		if (intervals.size()==0) {
			intervals.add(newInterval);
			return intervals;
		}
		List<Interval> answerList = new ArrayList<Interval>();
		int ns=0;
		int ne=0;
		boolean beginFlag=true;
		boolean endFlag=true;
		for (int i = 0; i < intervals.size(); i++) {
			if (endFlag&&beginFlag) {
				if (intervals.get(i).start>=s) {
					ns=s;
					beginFlag=false;
				}else if (intervals.get(i).end>=s) {
					if (intervals.get(i).end>=e) {
						endFlag=false;
					}else {
						ns=intervals.get(i).start;
						beginFlag=false;
					}
				}
			}
			if (endFlag&&!beginFlag) {
				if (intervals.get(i).start>e) {
					ne=e;
					answerList.add(new Interval(ns,ne));
					endFlag=false;
					beginFlag=true;
				}else if(intervals.get(i).start==e){
					ne=intervals.get(i).end;
					answerList.add(new Interval(ns,ne));
					endFlag=false;
					beginFlag=true;
					continue;
				}else if(intervals.get(i).end>=e){
					ne=intervals.get(i).end;
					answerList.add(new Interval(ns,ne));
					endFlag=false;
					beginFlag=true;
					continue;
				}else if(i==intervals.size()-1){
					ne=e;
					answerList.add(new Interval(ns,ne));
					return answerList;
				}
			}
			if (beginFlag) {
				answerList.add(intervals.get(i));
			}
		}
		if (endFlag) {
			answerList.add(newInterval);
		}
		return answerList;
	}
}