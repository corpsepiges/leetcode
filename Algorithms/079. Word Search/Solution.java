public class Solution {
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