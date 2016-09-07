public class Solution {
    public boolean validUtf8(int[] data) {
        //表示现在结束的结果
        boolean flag=true;
        //表示还需要10开头的数字的个数
        int need=0;
        for (int d:data) {
            //表示第一个0从头数是第几位
            int t=9-Integer.toBinaryString(d^255).length();
            if (flag) {
                if (t==1) {
                    continue;
                }else if(t==2){
                    return false;
                }else{
                    flag=false;
                    need=t-2;
                }
            }else{
                if (t==2) {
                    if (need--==1) {
                        flag=true;
                    }
                }else{
                    return false;
                }
            }
        }
        return flag;
    }
}