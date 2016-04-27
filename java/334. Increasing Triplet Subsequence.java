public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length<3) {
            return false;
        }
        List<Integer> list=new ArrayList<Integer>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (list.size()==1) {
                if (nums[i]<=list.get(0)) {
                    list.remove(0);
                }
                list.add(nums[i]);
            }else {
                if (nums[i]!=list.get(0)&&nums[i]!=list.get(1)) {
                    if (nums[i]>list.get(0)&&nums[i]>list.get(1)) {
                        return true;
                    }else if (nums[i]>list.get(0)&&nums[i]<list.get(1)) {
                        list.remove(1);
                    }else {
                        list.remove(0);
                    }
                    list.add(nums[i]);
                }
            }
        }
        return false;
    }
}