public class Solution {
    public int[] largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sumList=new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            int length=0;
            int index=-1;
            for (int j = 0; j < sumList.size(); j++) {
                if (sumList.get(j).size()>length&&nums[i]%sumList.get(j).get(sumList.get(j).size()-1)==0) {
                    index=j;
                    length=sumList.get(j).size();
                }
            }
            List<Integer> test=new ArrayList<Integer>();
            if (index!=-1) {
                test.addAll(sumList.get(index));
            }
            test.add(nums[i]);
            sumList.add(test);
        }
        int index=0;
        int length=0;
        for (int i = 0; i < sumList.size(); i++) {
            if (sumList.get(i).size()>length) {
                length=sumList.get(i).size();
                index=i;
            }
        }
        int[] ans=new int[length];
        for (int i = 0; i < length; i++) {
            ans[i]=sumList.get(index).get(i);
        }
        return ans;
    }
}