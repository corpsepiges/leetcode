public class Solution {
    public String numberToWords(int num) {
        if (num==0) {
			return "Zero";
		}
    	Map<String, String> map=new HashMap<String, String>();
    	map.put("1", "One");
    	map.put("2", "Two");
    	map.put("3", "Three");
    	map.put("4", "Four");
    	map.put("5", "Five");
    	map.put("6", "Six");
    	map.put("7", "Seven");
    	map.put("8", "Eight");
    	map.put("9", "Nine");
    	map.put("10", "Ten");
    	map.put("11", "Eleven");
    	map.put("12", "Twelve");
    	map.put("13", "Thirteen");
    	map.put("14", "Fourteen");
    	map.put("15", "Fifteen");
    	map.put("16", "Sixteen");
    	map.put("17", "Seventeen");
    	map.put("18", "Eighteen");
    	map.put("19", "Nineteen");
    	map.put("20", "Twenty");
    	map.put("30", "Thirty");
    	map.put("40", "Forty");
    	map.put("50", "Fifty");
    	map.put("60", "Sixty");
    	map.put("70", "Seventy");
    	map.put("80", "Eighty");
    	map.put("90", "Ninety");
        String str=String.valueOf(num);
        int length=str.length();
        List<String> list=new ArrayList<String>();
        while (str.length()>3) {
			list.add(str.substring(length-3,length));
			str=str.substring(0,length-3);
			length=str.length();
		}
        list.add(str);
        System.out.println("list.size()="+list.size());
        List<String> ansList=new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
			ansList.add(f(list.get(i),map));
		}
        String ans="";
        if (ansList.size()!=0) {
			ans=ansList.get(0);
			ansList.remove(0);
		}
        if (ansList.size()!=0) {
        	if (ansList.get(0).length()!=0) {
        		if (ans.length()==0) {
        			ans=ansList.get(0)+" Thousand";
        		}else {
        			ans=ansList.get(0)+" Thousand "+ans;
        		}
			}
			ansList.remove(0);
		}
        if (ansList.size()!=0) {
        	if (ansList.get(0).length()!=0) {
        		if (ans.length()==0) {
        			ans=ansList.get(0)+" Million";
        		}else {
        			ans=ansList.get(0)+" Million "+ans;
        		}
			}
			ansList.remove(0);
		}
        if (ansList.size()!=0) {
        	if (ansList.get(0).length()!=0){
        		if (ans.length()==0) {
        			ans=ansList.get(0)+" Billion";
        		}else {
        			ans=ansList.get(0)+" Billion "+ans;
        		}
        	}
			ansList.remove(0);
		}
    	return ans;
    }
    public String f(String str,Map<String, String> map){
    	StringBuffer sb=new StringBuffer();
    	int i=Integer.parseInt(str);
    	if (i>=100) {
			sb.append(map.get(""+i/100));
			sb.append(" Hundred");
		}
    	i=i%100;
    	if (i!=0) {
    		if (sb.length()!=0) {
				sb.append(" ");
			}
			if (i%100<20) {
				sb.append(map.get(""+i));
			}else {
				sb.append(map.get(""+(i-i%10)));
				if (i%10!=0) {
					sb.append(" ");
					sb.append(map.get(""+i%10));
				}
			}
		}
    	return sb.toString();
    }
}