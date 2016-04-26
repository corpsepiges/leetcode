public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        String a = "(";
        list.add(a);
        for (int i = 1; i <= 2 * n - 1; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                String s = list.get(j);
                int use = 0;
                int have = 0;
                // 判断当前的字符串已经使用掉的"("和还未被")"消耗掉的"("
                for (int k = 0; k < s.length(); k++) {
                    if (s.substring(k, k + 1).equals("(")) {
                        use++;
                        have++;
                    }
                    if (s.substring(k, k + 1).equals(")")) {
                        have--;
                    }
                }
                if (use == n) {
                    s += ")";
                    list.add(s);
                } else if (have == 0) {
                    s += "(";
                    list.add(s);
                } else {
                    String sa = s + "(";
                    String sb = s + ")";
                    list.add(sa);
                    list.add(sb);
                }
            }
            for (int j = size - 1; j >= 0; j--) {
                list.remove(j);
            }
        }

        return list;
    }
}