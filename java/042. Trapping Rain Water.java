public class Solution {
        public int trap(int[] height) {
    	if (height.length<=1) {
			return 0;
		}
    	int a=0;
    	int h=height[a];
    	/**
    	 * 求出最高峰
    	 */
        for (int i = 1; i < height.length; i++) {
        	if (height[i]>h) {
				a=i;
				h=height[i];
			}
		}
        Map<String, Integer> leftMap=new HashMap<String, Integer>();
        Map<String, Integer> rightMap=new HashMap<String, Integer>();
        leftMap.put("result", 0);
        leftMap.put("a",a);
        rightMap.put("result", 0);
        rightMap.put("a",a);
        Map<String, Integer> leftrRsult=new Solution().left(leftMap, height);
        Map<String, Integer> rightResult=new Solution().right(leftMap, height);
    	return leftrRsult.get("result")+rightResult.get("result");
    }
    
    /**
     * 求左侧
     * @param height
     * @param a
     * @return
     */
    public Map<String, Integer> left(Map<String, Integer> m,int[] height){
    	Map<String, Integer> map=new HashMap<String, Integer>();
    	if (m==null||m.get("a")==null) {
			return m;
		}
    	if (m.get("a")<=1) {
			return m;
		}
    	int h=height[0];
    	int result=m.get("result");
    	int sum=0;
    	int a=0;
    	for (int i = 1; i <m.get("a"); i++) {
			if (height[i]<h) {
				sum+=(h-height[i]);
			}else {
				sum=0;
				h=height[i];
				a=i;
			}
		}
    	result+=sum;
    	map.put("result", result);
    	map.put("a", a);
            	
    	return left(map, height);
    }
    /**
     * 求右侧
     * @param height
     * @param a
     * @return
     */
    public Map<String, Integer> right(Map<String, Integer> m,int[] height){
    	Map<String, Integer> map=new HashMap<String, Integer>();
    	if (m==null||m.get("a")==null) {
			return m;
		}
    	if (m.get("a")>=height.length-2) {
			return m;
		}
    	int h=height[height.length-1];
    	int result=m.get("result");
    	int sum=0;
    	int a=0;
    	for (int i = height.length-1; i>m.get("a"); i--) {
			if (height[i]<h) {
				sum+=(h-height[i]);
			}else {
				sum=0;
				h=height[i];
				a=i;
			}
		}
    	result+=sum;
    	map.put("result", result);
    	map.put("a", a);
            	
    	return right(map, height);
    }
}