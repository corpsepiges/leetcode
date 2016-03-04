public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    	return f(s1,s2,s3,new HashMap<String, Boolean>());
    }
    public boolean f(String s1, String s2, String s3,Map<String,Boolean> map){
    	if (map.get(s1+","+s2+","+s3)==null) {
        	if (s3.length()!=(s1.length()+s2.length())) {
        		return false;
        	}
        	if (s3.length()==0) {
        		return true;
        	}
        	
        	String w=s3.substring(0,1);
        	boolean flag1=false;
        	boolean flag2=false;
        	if (s1.length()!=0) {
        		if(s2.length()==0){
        			flag1=s1.equals(s3);
        		}else {
        			String w1=s1.substring(0,1);
        			if (w.equals(w1)) {
        				flag1=f(s1.substring(1, s1.length()),s2,s3.substring(1, s3.length()),map);
        			}
    			}
        		if (flag1) {
        			return flag1;
        		}else {
        			map.put(s1.substring(1, s1.length())+","+s2+","+s3.substring(1, s3.length()),false);
        		}
        	}
        	if (s2.length()!=0) {
        		if (s1.length()==0) {
        			flag2=s2.equals(s3);
    			}else {
    				String w2=s2.substring(0,1);
    				if (w.equals(w2)) {
    					flag2=f(s1,s2.substring(1, s2.length()),s3.substring(1, s3.length()),map);
    				}
    			}
        		if (flag2) {
        			return flag2;
        		}else {
        			map.put(s1+","+s2.substring(1, s2.length())+","+s3.substring(1, s3.length()),false);
        			map.put(s1+","+s2+","+s3,false);
        		}
        	}
        }
    	return false;
    }
    
    
}