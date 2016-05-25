public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //验证每行每列有没有重复数据
        for (int i = 0; i < 9; i++) {
            Map<Character, String> cross=new HashMap<Character, String>();
            Map<Character, String> vertical=new HashMap<Character, String>();
            for (int j = 0; j < 9; j++) {
                if (!(board[i][j]=='.')) {
                    if (cross.get(board[i][j])!=null) {
                        return false;
                    }else {
                        cross.put(board[i][j], "");
                    }
                }
                if (board[j][i]!='.') {
                    if (vertical.get(board[j][i])!=null) {
                        return false;
                    }else {
                        vertical.put(board[j][i], "");
                    }
                }
            }
        }
        //验证每个小九个字有无重复数据
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                Map<Character, String> squ=new HashMap<Character, String>();
                for (int c = 0; c < 3; c++) {
                    for (int d = 0; d < 3; d++) {
                    if (board[3*a+c][3*b+d]!='.') {
                        if (squ.get(board[3*a+c][3*b+d])!=null) {
                            return false;
                        }else {
                            squ.put(board[3*a+c][3*b+d], "");
                        }
                    }
                    }
                }
            }
        }
    return true;
    }
}