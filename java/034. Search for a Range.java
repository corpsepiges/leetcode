public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int begin=0;
        int end=nums.length-1;
        int a=(begin+end)/2;
        int[] answer=new int[2];
        while (nums[a]!=target) {
            if(begin==end){
                answer[0]=-1;
                answer[1]=-1;
                return answer;
            }
        if (nums[a]>target) {
                if (a==end) {
                    end--;
                }else {
                    end=a;
                }
                
            }else {
                if (a==begin) {
                    begin++;
                }else {
                    begin=a;
                }
                
            }
            a=(begin+end)/2;
        }
        int bb=0;
        int be=a;
        int ba=(bb+be)/2;
            while (!(nums[ba]==target&&(ba==0||nums[ba-1]!=target))) {
            if (nums[ba]>=target) {
                if (ba==be) {
                    be--;
                }else {
                    be=ba;
                }
            }else {
                if (ba==bb) {
                    bb++;
                }else {
                    bb=ba;
                }
            }
            ba=(bb+be)/2;
        }
        int eb=a;
        int ee=nums.length-1;
        int ea=(eb+ee)/2;
while (!(nums[ea]==target&&(ea==nums.length-1||nums[ea+1]!=target))) {
            if (nums[ea]<=target) {
                if (ea==eb) {
                    eb++;
                }else {
                    eb=ea;
                }
            }else {
                if (ea==ee) {
                    ee--;
                }else {
                    ee=ea;
                }
                }
            ea=(eb+ee)/2;
        }
             answer[0]=ba;
                answer[1]=ea;
        return answer;
    }
}