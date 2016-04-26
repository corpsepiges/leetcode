public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list=new ArrayList<Integer>();
        int length=nums.length;
        if (length==0) {
            return list;
        }
        List<Integer> ars=new ArrayList<Integer>();
        ars.add(nums[length-1]);
        list.add(0);
        for (int i = length-2; i >=0; i--) {
            int test=nums[i];
            int end=ars.size()-1;
            int start=0;
            int mid=(start+end)/2;
            while (end-start>1) {
                if (test<=ars.get(mid)) {
                    end=mid;
                }else {
                    start=mid;
                }
                mid=(start+end)/2;
            }
            int res=end+1;
            if (test<=ars.get(start)) {
                res=start;
            }else if (test<=ars.get(end)) {
                res=end;
            }
            ars.add(res,test);
            list.add(0,res);
        }
        return list;
    }
}