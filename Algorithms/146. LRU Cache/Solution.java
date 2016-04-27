public class LRUCache {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private int length;
    public LRUCache(int capacity) {
        list=new ArrayList<Integer>();
        map=new HashMap<Integer, Integer>();
        length=capacity;
    }
    
    public int get(int key) {
        if (map.get(key)!=null) {
            set(key, map.get(key));
            return map.get(key);
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (map.get(key)==null) {
            if (list.size()==length) {
                map.remove(list.get(0));
                list.remove(0);
            }
        }else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)==key) {
                    list.remove(i);
                    break;
                }
            }
        }
        list.add(key);
        map.put(key, value);
    }
}