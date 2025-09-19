class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            dfs(i, 0, heights, pacific);
            dfs(i, cols - 1, heights, atlantic);
        }
        for (int j = 0; j < cols; j++) {
            dfs(0, j, heights, pacific);
            dfs(rows - 1, j, heights, atlantic);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    private void dfs(int x, int y, int[][] heights, boolean[][] vis) {
        int rows = heights.length, cols = heights[0].length;
        vis[x][y] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !vis[newX][newY] && heights[newX][newY] >= heights[x][y]) {
                dfs(newX, newY, heights, vis);
            }
        }
    }
}