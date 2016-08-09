import java.util.Random;
public class RandomizedSet {
    List<Integer> list;
    Random r;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list=new ArrayList<Integer>();
        r=new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        Integer v=val;
        if(list.contains(v)){
            return false;
        }
        list.add(v);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer v=val;
        if(list.contains(v)){
            list.remove(v);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */