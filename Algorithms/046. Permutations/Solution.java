public class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> answerList=new ArrayList<List<Integer>>();
            for (int i = 0; i < nums.length; i++) {
                int size=answerList.size();
                if (size==0) {
                    for (int j = 0; j < nums.length; j++) {
                        List<Integer> intList=new ArrayList<Integer>();
                        intList.add(nums[j]);
                        answerList.add(intList);
                    }
                }else {
                    for (int j = 0; j < size; j++) {
                        List<Integer> intList=answerList.get(j);
                        Map<Integer,String> map=new HashMap<Integer,String>();
                        for (int l = 0; l <intList.size(); l++) {
                            map.put(intList.get(l), "存在");
                        }
                        for (int k = 0; k < nums.length; k++) {
                            if (map.get(nums[k])==null) {
                                System.out.println("k="+k);
                                List<Integer> newList=new ArrayList<Integer>();
                                for (int l = 0; l < intList.size(); l++) {
                                    newList.add(intList.get(l));
                                }
                                newList.add(nums[k]);
                                System.out.println();
                                answerList.add(newList);
                            }
                        }
                    }
                    if (size!=answerList.size()) {
                        for (int j = size-1; j >=0; j--) {
                            answerList.remove(j);
                        }
                    }
                }
            }
         
         return answerList;
        }
}