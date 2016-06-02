/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    Map<Integer, Interval> before ;
    Map<Integer,Interval> end;
    Map<Integer,Integer> finish;
    List<Interval> list;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        before=new HashMap<Integer, Interval>();
        end=new HashMap<Integer, Interval>();
        finish=new HashMap<Integer,Integer>();
        list=new ArrayList<>();
    }
    
    public void addNum(int val) {
        if (finish.get(val)==null) {
            if (before.get(val)==null&&end.get(val)==null) {
                Interval iv=new Interval(val,val);
                before.put(val-1, iv);
                end.put(val+1, iv);
                if (list.size()==0) {
                    list.add(iv);
                }else if (list.get(0).start>val) {
                    list.add(0, iv);
                }else{
                    for (int i = list.size()-1; i>=0; i--) {
                        if (val>list.get(i).end) {
                            list.add(i+1,iv);
                            break;
                        }
                    }
                }
            }else if(before.get(val)==null){
                end.get(val).end=val;
                end.put(val+1, end.get(val));
                end.remove(val);
            }else if(end.get(val)==null){
                before.get(val).start=val;
                before.put(val-1, before.get(val));
                before.remove(val);
            }else{
                Interval b=end.get(val);
                Interval e=before.get(val);
                e.start=b.start;
                end.remove(val);
                before.remove(val);
                before.put(b.start-1, e);
                list.remove(b);
            }
            finish.put(val, 1);
        }
    }
    
    public List<Interval> getIntervals() {
        return list;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */