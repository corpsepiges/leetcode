public class Solution {
    boolean[][] rPO;
    int[][] v4PO;
    boolean[][] rAO;
    int[][] v4AO;
    int m;
    int n;
    int[][] matrix;

    public List<int[]> pacificAtlantic(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        List<int[]> res = new ArrayList<int[]>();
        if (m == 0) {
            return res;
        }
        n = matrix[0].length;
        rPO = new boolean[m][n];
        v4PO = new int[m][n];
        rAO = new boolean[m][n];
        v4AO = new int[m][n];
        for (int i = 0; i < m; i++) {
            visitForPacificOcean(i, 0, 0);
            visitForAtlanticOcean(i, n - 1, 0);
        }
        for (int i = 0; i < n; i++) {
            visitForPacificOcean(0, i, 0);
            visitForAtlanticOcean(m - 1, i, 0);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rPO[i][j] && rAO[i][j]) {
                    int[] ans = { i, j };
                    res.add(ans);
                }
            }
        }
        return res;
    }

    public void visitForPacificOcean(int x, int y, int lastHeight) {
        if (x >= 0 && x < m && y >= 0 && y < n && v4PO[x][y] == 0 && matrix[x][y] >= lastHeight) {
            rPO[x][y] = true;
            v4PO[x][y] = 1;
            visitForPacificOcean(x - 1, y, matrix[x][y]);
            visitForPacificOcean(x + 1, y, matrix[x][y]);
            visitForPacificOcean(x, y - 1, matrix[x][y]);
            visitForPacificOcean(x, y + 1, matrix[x][y]);
        }
    }

    public void visitForAtlanticOcean(int x, int y, int lastHeight) {
        if (x >= 0 && x < m && y >= 0 && y < n && v4AO[x][y] == 0 && matrix[x][y] >= lastHeight) {
            rAO[x][y] = true;
            v4AO[x][y] = 1;
            visitForAtlanticOcean(x - 1, y, matrix[x][y]);
            visitForAtlanticOcean(x + 1, y, matrix[x][y]);
            visitForAtlanticOcean(x, y - 1, matrix[x][y]);
            visitForAtlanticOcean(x, y + 1, matrix[x][y]);
        }
    }
}