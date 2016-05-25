public class Solution {
    public void solve(char[][] board) {
        if (board!=null&&board.length!=0&&board[0].length!=0) {
            int row=board.length;
            int col=board[0].length;
            List<Integer> test=new ArrayList<Integer>();
            for (int i = 0; i < row; i++) {
                if (board[i][0]=='O') {
                    test.add(i*col);
                }
                if (board[i][col-1]=='O') {
                    test.add(i*col+col-1);
                }
            }
            for (int i = 0; i < col; i++) {
                if (board[0][i]=='O') {
                    test.add(i);
                }
                if (board[row-1][i]=='O') {
                    test.add((row-1)*col+i);
                }
            }
            int a=0;
            while (a<test.size()) {
                int key=test.get(a++);
                int x=key/col;
                int y=key%col;
                if (x>=0&&x<row&&y>=0&&y<col&&'O'==board[x][y]) {
                    board[x][y]='A';
                    test.add(key-col);
                    test.add(key+col);
                    test.add(key-1);
                    test.add(key+1);
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j]!='A') {
                        board[i][j]='X';
                    }else{
                        board[i][j]='O';
                    }
                }
            }
        }
    }
}