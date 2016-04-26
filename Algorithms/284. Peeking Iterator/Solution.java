// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    public List<Integer> list=new ArrayList<Integer>();

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        while(iterator.hasNext()){
            list.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(0);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer i=list.get(0);
        list.remove(0);
        return i;
    }

    @Override
    public boolean hasNext() {
        return list.size()>0;
    }
}