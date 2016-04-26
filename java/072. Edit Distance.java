public class Solution {
    public int minDistance(String word1, String word2) {
        int l1=word1.length();
        int l2=word2.length();
        if (l1*l2==0) {
            return l1==0?l2:l1;
        }
        int[][] board=new int[l1+1][l2+1];
        for (int i = 0; i < l1+1; i++) {
            board[i][0]=i;
        }
        for (int i = 0; i < l2+1; i++) {
            board[0][i]=i;
        }
        char[] c1=word1.toCharArray();
        char[] c2=word2.toCharArray();
        for (int i = 1; i < l1+1; i++) {
            for (int j = 1; j < l2+1; j++) {
                if (c1[i-1]==c2[j-1]) {
                    board[i][j]=board[i-1][j-1];
                }else {
                    board[i][j]=Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1])+1;
                }
            }
        }
        return board[l1][l2];
    }
}