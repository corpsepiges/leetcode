public class Solution {
    public List<String> letterCombinations(String digits) {
	//存放答案的list
        List<String> list=new ArrayList<String>();
        //建立map存放手机按键
        Map<String, List<String>> map=new HashMap<String, List<String>>();
        List<String> list2=new ArrayList<String>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        List<String> list3=new ArrayList<String>();
        list3.add("d");
        list3.add("e");
        list3.add("f");
        List<String> list4=new ArrayList<String>();
        list4.add("g");
        list4.add("h");
        list4.add("i");
        List<String> list5=new ArrayList<String>();
        list5.add("j");
        list5.add("k");
        list5.add("l");
        List<String> list6=new ArrayList<String>();
        list6.add("m");
        list6.add("n");
        list6.add("o");
        List<String> list7=new ArrayList<String>();
        list7.add("p");
        list7.add("q");
        list7.add("r");
        list7.add("s");
        List<String> list8=new ArrayList<String>();
        list8.add("t");
        list8.add("u");
        list8.add("v");
        List<String> list9=new ArrayList<String>();
        list9.add("w");
        list9.add("x");
        list9.add("y");
        list9.add("z");
        map.put("2", list2);
        map.put("3", list3);
        map.put("4", list4);
        map.put("5", list5);
        map.put("6", list6);
        map.put("7", list7);
        map.put("8", list8);
        map.put("9", list9);
        //循环判断
        for (int i = 0; i < digits.length(); i++) {
			String s=digits.substring(i,i+1);
			//如果能查到数字键盘
			if (map.get(s)!=null) {
				//如果list不为空，即并非刚开始
				if (list.size()!=0) {
					//记住目前list的长度
					int size=list.size();
					//循环list当前长度
					for (int j = 0; j < size; j++) {
						//将list中的每个值与接下来的对应数字键盘的可能性进行拼接
						for (int k = 0; k <map.get(s).size(); k++) {
							String a=list.get(j)+map.get(s).get(k);
							list.add(a);
						}
					}
					//删掉之前的list
					for (int j = size-1; j >=0; j--) {
						list.remove(j);
					}
				}else {
					for (int j = 0; j < map.get(s).size(); j++) {
						String a=map.get(s).get(j);
						list.add(a);
					}
				}
			}
		}
        return list;
    }
}