public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length<=1){
            return false;
        }
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], "");
                if (i >= k) {
                    map.remove(nums[i - k]);
                }
            } else {
                return true;
            }
        }
    return false;
    }
}