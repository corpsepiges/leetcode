public class Solution {
    public int numIslands(char[][] grid) {
        int il = 0;
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (map.get("(" + i + "," + j + ")") == null) {
                    if (grid[i][j] == '1') {
                        il++;
                        map = new Solution().ss(map, i, j, grid);
                    }
                }
            }
        }
        return il;
    }
   public Map<String,String> ss(Map<String,String> map,int i,int j,char[][] grid){
        if (map.get("(" + i + "," + j + ")") == null && grid[i][j] == '1') {
            int LI = grid.length;
            int LJ = grid[i].length;
            map.put("(" + i + "," + j + ")", "1");
            if (i > 0) {
                // 上边检测
                map = ss(map, i - 1, j, grid);
            }
            if (i < LI - 1) {
                // 下边检测
                map = ss(map, i + 1, j, grid);
            }
            if (j > 0) {
                // 左边检测
                map = ss(map, i, j - 1, grid);
            }
            if (j < LJ - 1) {
                // 右边检测
                map = ss(map, i, j + 1, grid);
            }
        }
        return map;
    }
}