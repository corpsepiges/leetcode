public class Solution {
    public int totalNQueens(int n) {
        return solveNQueens(n).size();
    }
    
    public List<List<String>> solveNQueens(int n) {
        //装n皇后的数组
        int[] nums=new int[n];
        //答案
        List<List<String>> ans=new ArrayList<List<String>>();
        int i=0;
        while (true) {
            //所有可能已经尝试完毕，退出游戏
            if (i<0) {
                return ans;
            }
            //成功尝试出一种答案， 装载答案
            if (i==n) {
                List<String> list=new ArrayList<String>();
                for (int j = 0; j < nums.length; j++) {
                    StringBuffer sb=new StringBuffer();
                    for (int k = 0; k < n; k++) {
                        if (k!=nums[j]) {
                            sb.append(".");
                        }else {
                            sb.append("Q");
                        }
                    }
                    list.add(sb.toString());
                }
                ans.add(list);
                //回退
                i--;
                while (nums[i]==n) {
                    nums[i]=0;
                    i--;
                }
                nums[i]++;
            }else {
                if (nums[i]==n) {
                    //回退
                    while (i>=0&&nums[i]==n) {
                        nums[i]=0;
                        i--;
                    }
                    if (i>=0) {
                        nums[i]++;
                    }
                }else {
                    if (f(nums,i,nums[i])) {
                        i++;
                    }else {
                        nums[i]++;
                    }
                }
            }
            
        }
//        return ans;
    }
    public boolean f(int[] nums,int x,int val){
        for (int i = 0; i < x; i++) {
            int t=x-i;
            if (val==nums[i]||val==nums[i]+t||val==nums[i]-t) {
                return false;
            }
        }
        return true;
    }
}