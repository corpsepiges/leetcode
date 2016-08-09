import java.util.Random;
public class RandomizedCollection {
    List<Integer> list;
    Random r;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list=new ArrayList<Integer>();
        r=new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Integer v=val;
        boolean flag=list.contains(v);
        list.add(v);
        return !flag;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Integer v=val;
        boolean flag=list.contains(v);
        list.remove(v);
        return flag;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */