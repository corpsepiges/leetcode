/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> ans;
	private int index;
	private int length;
	
    public NestedIterator(List<NestedInteger> nestedList) {
        ans=init(nestedList);
        index=0;
        length=ans.size();
    }

    @Override
    public Integer next() {
		return index<length?ans.get(index++):null;
    }

    @Override
    public boolean hasNext() {
		return index<length;
    }
    
    public List<Integer> init(List<NestedInteger> nestedList){
    	List<Integer> list=new ArrayList<Integer>();
    	for (NestedInteger nestedInteger : nestedList) {
			if (nestedInteger.isInteger()) {
				list.add(nestedInteger.getInteger());
			}else{
				list.addAll(init(nestedInteger.getList()));
			}
		}
    	return list;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */