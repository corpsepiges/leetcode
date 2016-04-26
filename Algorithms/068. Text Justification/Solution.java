public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> sumList=new ArrayList<List<String>>();
        int length=maxWidth;
        List<String> list=new ArrayList<String>();
        //分行
        for (int i = 0; i < words.length; i++) {
            if (words[i].length()<=length) {
                list.add(words[i]);
                length-=(words[i].length()+1);
            }else {
                sumList.add(list);
                list=new ArrayList<String>();
                length=maxWidth;
                i--;
            }
        }
        if (list.size()!=0) {
            sumList.add(list);
        }
        List<String> ans=new ArrayList<String>();
        //处理每行的字符串
        for (int i = 0; i < sumList.size()-1; i++) {
            List<String> l=sumList.get(i);
            //区分一行只有一个字符串的和多个字符串的情况
            if (l.size()==1) {
                StringBuffer sb=new StringBuffer();
                sb.append(l.get(0));
                for (int j = 0; j < maxWidth-l.get(0).length(); j++) {
                    sb.append(" ");
                }
                System.out.println("sb.toString()="+sb.toString());
                ans.add(sb.toString());
            }else {
                int totalSpace=maxWidth;
                for (int j = 0; j < l.size(); j++) {
                    totalSpace-=l.get(j).length();
                }
                int eachSpace=totalSpace/(l.size()-1);
                int extraSpace=totalSpace-eachSpace*(l.size()-1);
                StringBuffer sb=new StringBuffer();
                for (int j = 0; j < l.size()-1; j++) {
                    sb.append(l.get(j));
                    for (int k = 0; k < eachSpace; k++) {
                        sb.append(" ");
                    }
                    if (j<extraSpace) {
                        sb.append(" ");
                    }
                }
                sb.append(l.get(l.size()-1));
                ans.add(sb.toString());
            }
        }
        //处理最后一行
        List<String> l=sumList.get(sumList.size()-1);
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < l.size()-1; i++) {
            sb.append(l.get(i));
            sb.append(" ");
        }
        sb.append(l.get(l.size()-1));
        int tt=sb.toString().length();
        for (int j = 0; j < maxWidth-tt; j++) {
            sb.append(" ");
        }
        ans.add(sb.toString());
        return ans;
    }
}