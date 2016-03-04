public class Solution {
    public int nthUglyNumber(int n) {
        if (n<7) {
			return n;
		}
        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        while (list.size()<n) {
			list=a(list);
		}
        return list.get(n-1);
    }
    public List<Integer> a(List<Integer> list){
    	int end=list.get(list.size()-1);
    	int a2=0;
    	int a3=0;
    	int a5=0;
    	int k=0;
    	for (int i = 0; i < list.size(); i++) {
			if (list.get(i)*5>end) {
				a5=list.get(i)*5;
				k=i;
				break;
			}
		}
    	for (int i = k; i < list.size(); i++) {
			if (list.get(i)*3>end) {
				a3=list.get(i)*3;
				k=i;
				break;
			}
		}
    	for (int i = k; i < list.size(); i++) {
			if (list.get(i)*2>end) {
				a2=list.get(i)*2;
				k=i;
				break;
			}
		}
    	int a=0;
    	if (a2<a3) {
			a=a2<a5?a2:a5;
		}else {
			a=a3<a5?a3:a5;
		}
    	list.add(a);
    	return list;
    }
}