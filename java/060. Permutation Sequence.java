public class Solution {
    public String getPermutation(int n, int k) {
        int s=1;
        List<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i <n; i++) {
            list.add(i+1);
        }
        for (int i = 1; i <n; i++) {
            s*=i;
        }
        int t=n-1;
        StringBuffer answer=new StringBuffer();
        for (;t!=0;) {
            answer.append(list.get((k-1)/s));
            list.remove((k-1)/s);
            k-=((k-1)/s*s);
            s/=t;
            t--;
        }
        return answer.append(list.get(0)).toString();
    }
}