public class Solution {
    Map<Character, Map<Character, Integer>> map=new HashMap<Character, Map<Character,Integer>>();
    Map<String,Integer> finish=new HashMap<String, Integer>();
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans=new ArrayList<String>();
        init(board);
        for (int i = 0; i < words.length; i++) {
            if (finish.get(words[i])==null&&pre(words[i])&&exist(board, words[i])) {
                ans.add(words[i]);
            }
            //验证过的字符串不再次验证
            finish.put(words[i], 1);
        }
        return ans;
    }
    /**
     * 粗略判断，判断字符串中的每个字符是否出现在表格上以及下一个字符是否在该字符周围可以找到
     * @author xuxuan
     * @date 2015-11-4下午04:23:28
     * @param word
     * @return
     */
    public boolean pre(String word){
        char[] c=word.toCharArray();
        for (int i = 0; i < c.length-1; i++) {
            char b=c[i];
            char e=c[i+1];
            if (map.get(b)==null||map.get(b).get(e)==null) {
                return false;
            }
        }
        return true;
    }
    /**
     * 预处理，先把每个字符周围的值写进map
     * @param board
     */
    public void init(char[][] board){
        int iL=board.length;
        int jL=board[0].length;
        for (int i = 0; i < iL; i++) {
            for (int j = 0; j < jL; j++) {
                Map<Character, Integer> m=map.get(board[i][j]);
                if (m==null) {
                    m=new HashMap<Character, Integer>();
                }
                if (i-1>=0) {
                    m.put(board[i-1][j], 1);
                }
                if (i+1<iL) {
                    m.put(board[i+1][j], 1);
                }
                if (j-1>=0) {
                    m.put(board[i][j-1], 1);
                }
                if (j+1<jL) {
                    m.put(board[i][j+1], 1);
                }
                map.put(board[i][j], m);
            }
        }
    }
    public boolean exist(char[][] board, String word) { 
        if (word==null||word.length()==0||board==null||board.length==0) {  
            return false;  
        }  
        char[] ch=word.toCharArray();  
        int length=ch.length;  
        int m=board.length;  
        int n=board[0].length;  
        boolean[][] flag=new boolean[m][n];  
        for (int i = 0; i < board.length; i++) {  
            for (int j = 0; j < board[i].length; j++) {  
                if (board[i][j]==ch[0]&&f(board,ch,0,i,j,length,m,n,flag)) {
                    return true;  
                }  
            }  
        }  
        return false;  
    }
    /**
     * 各参数含义
     * @param board    参照表格
     * @param ch    测试的字符串转成字符数组
     * @param level    测试数组的下标
     * @param x        探测表格的横坐标
     * @param y        探测表格的纵坐标
     * @param length数组的长度
     * @param m        表格的横长
     * @param n        表格的纵长
     * @param flag    标记表格该位置的字符是否被使用过，true表示使用过，false表示未使用过
     * @return
     */
    public boolean f(char[][] board,char[] ch,int level,int x,int y,int length,int m,int n,boolean[][] flag){  
        if (level==length) {  
            return true;  
        }  
        if (x<0||x>=m||y<0||y>=n||flag[x][y]||board[x][y]!=ch[level]) {  
            return false;  
        }
        flag[x][y]=true;  
        if (f(board,ch,level+1,x+1,y,length,m,n,flag)) {  
            return true;  
        }  
        if (f(board,ch,level+1,x-1,y,length,m,n,flag)) {  
            return true;  
        }  
        if (f(board,ch,level+1,x,y+1,length,m,n,flag)) {  
            return true;  
        }  
        if (f(board,ch,level+1,x,y-1,length,m,n,flag)) {  
            return true;  
        }  
        flag[x][y]=false;
        return false;  
    }  
}