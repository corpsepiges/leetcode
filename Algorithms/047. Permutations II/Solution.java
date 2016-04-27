public class Solution {
    Map<String, List<List<Integer>>> map=new HashMap<String, List<List<Integer>>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return f(list);
    }
    public List<List<Integer>> f(List<Integer> list){
        String str=g(list);
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if (map.get(str)==null) {
            if (list.size()==1) {
                ans.add(list);
            }else {
                for (int i = 0; i < list.size(); i++) {
                    if (i==0||list.get(i)!=list.get(i-1)) {
                        Integer test=list.get(i);
                        list.remove(i);
                        List<List<Integer>> ts=f(list);
                        for (int j = 0; j < ts.size(); j++) {
                            List<Integer> t=new ArrayList<Integer>();
                            t.add(test);
                            t.addAll(ts.get(j));
                            ans.add(t);
                        }
                        list.add(i,test);
                    }
                }
            }
            map.put(str, ans);
        }
        return map.get(str);
    }
    public String g(List<Integer> list){
        StringBuffer sb=new StringBuffer();
        for (Integer i:list) {
            sb.append(String.valueOf(i));
            sb.append(",");
        }
        return sb.toString();
    }
}