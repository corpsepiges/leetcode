public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //按照k排序，k小的放前面，k相同h小的放前面
        Comparator<int[]> c=new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[1] == arr2[1])  
                    return arr1[0] - arr2[0];  
                else  
                    return arr1[1] - arr2[1];  
            }
        };
        Arrays.sort(people,c);
        List<int[]> list=new ArrayList<int[]>();
        for (int i = 0; i < people.length; i++) {
            if (i==0) {
                list.add(people[i]);
            }else{
                //定位
                int h=people[i][0];
                int k=people[i][1];
                int j=0;
                boolean flag=true;
                while(j<list.size()&&k>=0&&flag){
                    if (list.get(j)[0]>=h) {
                        if (k==0) {
                            flag=false;
                            break;
                        }
                        k--;
                    }
                    j++;
                }
                list.add(j, people[i]);
            }
        }
        int[][] ans=new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i]=list.get(i);
        }
        return ans;
    }
}