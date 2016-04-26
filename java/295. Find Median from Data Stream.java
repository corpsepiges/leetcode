class MedianFinder {
    List<Integer> list=new ArrayList<Integer>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(list.size()==0){
            list.add(num);
        }else{
            int s=0;
            int e=list.size()-1;
            int m=(s+e)/2;
            while(e-s>1){
                if(list.get(m)==num){
                    list.add(m,num);
                    return;
                }
                if(list.get(m)<num){
                    s=m;
                }else{
                    e=m;
                }
                m=(s+e)/2;
            }
            if(list.get(e)<num){
                list.add(e+1,num);
            }else if(list.get(s)>num){
                list.add(s,num);
            }else{
                list.add(e,num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(list.size()==0){
            return (double)0;
        }
        int length=list.size();
        return ((double)list.get(length/2)+(double)list.get((length-1)/2))/2.0;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();