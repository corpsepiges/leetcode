	Map<Character,Map<Integer,Integer>> map=new HashMap<Character, Map<Integer,Integer>>();
	//装初始字符串数组
	String[] initStrs=null;
	//装处理过的字符串数组
	String[] nowStrs=null;
    public int maxProduct(String[] words) {
    	int length=words.length;
    	if (length<2) {
			return 0;
		}
    	initStrs=words;
    	nowStrs=new String[length];
    	Map<String,Integer> cond=null;
    	StringBuffer sb=null;
    	//对原数组进行处理，保证处理后的字符串中没有重复字母，缩减判断时间
    	for (int i = 0; i < length; i++) {
    		cond=new HashMap<String, Integer>();
    		sb=new StringBuffer();
    		for (int j = 0; j < words[i].length(); j++) {
    			String k=words[i].substring(j,j+1);
				if (cond.get(k)==null) {
					sb.append(k);
					cond.put(k,1);
				}
			}
    		nowStrs[i]=sb.toString();
		}
    	//遍历原有数组，按字符写进map
    	for (int i = 0; i < length; i++) {
			char[] cs=nowStrs[i].toCharArray();
			for (int j = 0; j < cs.length; j++) {
				if (map.get(cs[j])==null) {
					Map<Integer,Integer> m=new HashMap<Integer, Integer>();
					m.put(i, 1);
					map.put(cs[j], m);
				}else {
					map.get(cs[j]).put(i, 1);
				}
			}
		}
    	int max=0;
    	for (int i = 0; i < length; i++) {
			for (int j = i+1; j < length; j++) {
				int test=f(i,j);
				if (test>max) {
					max=test;
				}
			}
		}
    	return max;
    }
    public int f(int i,int j){
    	char[] csi=nowStrs[i].toCharArray();
    	//选择一个字符串开始读取，如果该字符串包含的任意一个另外字符串拥有的字符，则返回0
    	for (int k = 0; k < csi.length; k++) {
			if (map.get(csi[k]).get(j)!=null) {
				return 0;
			}
		}
    	return initStrs[i].length()*initStrs[j].length();
    }
