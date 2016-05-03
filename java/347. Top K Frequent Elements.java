public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map1=new HashMap<Integer, Integer>();
        Map<Integer,List<Integer>> map2=new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            map1.put(nums[i], map1.get(nums[i])==null?1:(map1.get(nums[i])+1));
        }
        Set<Integer> set=map1.keySet();
        int[] arrays=new int[set.size()];
        int a=0;
        for (Integer key : set) {
            int value=map1.get(key);
            if (map2.get(value)==null) {
                List<Integer> list=new ArrayList<Integer>();
                list.add(key);
                map2.put(value, list);
                arrays[a++]=value;
            }else {
                map2.get(value).add(key);
            }
        }
        Arrays.sort(arrays);
        List<Integer> list=new ArrayList<Integer>();
        a=arrays.length-1;
        while (list.size()<k) {
            list.addAll(map2.get(arrays[a--]));
        }
        return list;
    }
}