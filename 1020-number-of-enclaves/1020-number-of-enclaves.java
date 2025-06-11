class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        queue.add(new Pair(i, j));
                        visited[i][j] = 1;
                    }
                }
            }
        }

        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};

        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            for (int i = 0; i < 4; i++) {
                int newRow = row + delrow[i];
                int newcol = col + delcol[i];

                if (newRow >= 0 && newRow < n && newcol >= 0 && newRow < n && 
                        visited[newRow][newcol] == 0 && grid[newRow][newcol] == 1) {
                    queue.add(new Pair(newRow, newcol));
                    visited[newRow][newcol] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) count++;
            }
        }
        return count;
    }
}
public class Pair {
    int first, second;
    Pair (int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}