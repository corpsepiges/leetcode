public class Solution {
    public List<Integer> lexicalOrder(int n) {
        //k表示最大的数字的位数
        int k=0;
        int m=n;
        while (n!=0) {
            k+=1;
            n/=10;
        }
        int sum=(int) Math.pow(11, k);
        int[] nums=new int[sum];
        for (int i = 1; i <= m; i++) {
            nums[transfer(i, k)]=i;
        }
        List<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) {
                list.add(nums[i]);
            }
        }
        return list;
    }
    //求每个元素转化后对应的数字，取11进制，每个数设为k位数，如果不足就当后面补x补齐，x当做0，其他每个数当做其+1
    public int transfer(int n,int k){
        int ans=0;
        int b=1;
        for (int i = 0; i < k; i++) {
            if (n!=0) {
                ans+=(b*(n%10+1));
                b*=11;
                n/=10;
            }else{
                ans*=11;
            }
        }
        return ans;
    }
}