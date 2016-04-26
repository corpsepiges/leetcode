public class Solution {
    public void gameOfLife(int[][] board) {
        int[][] newboard=new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int k=board[i][j];
                int v=f(board,i,j);
                System.out.println("v="+v);
                if (v==3||(v==2&&k==1)) {
                    System.out.println("true");
                    newboard[i][j]=1;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j]=newboard[i][j];
            }
        }
    }
    public int f(int[][] board,int x,int y){
        return g(board,x-1,y-1)+g(board,x-1,y)+g(board,x-1,y+1)+g(board,x,y-1)+g(board,x,y+1)+g(board,x+1,y-1)+g(board,x+1,y)+g(board,x+1,y+1);
    }
    public int g(int[][] board,int x,int y){
        if (x>=0&&x<board.length&&y>=0&&y<board[x].length) {
            return board[x][y];
        }
        return 0;
    }
}