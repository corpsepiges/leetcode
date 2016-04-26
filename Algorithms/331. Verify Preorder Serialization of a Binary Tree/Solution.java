public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] strs=preorder.split(",");
        List<String> list=new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i]);
        }
        return isValid(list);
    }
    public boolean isValid(List<String> list) {
        int len=list.size();
        if (len==1) {
            return "#".equals(list.get(0));
        }
        for (int i = 0; i < len-2; i++) {
            if ("#".equals(list.get(i+1))&&"#".equals(list.get(i+2))) {
                if ("#".equals(list.get(i))) {
                    return false;
                }else{
                    list.remove(i+2);
                    list.remove(i+1);
                    list.remove(i);
                    list.add(i,"#");
                    return isValid(list);
                }
            }
        }
        return false;
    }
}