class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != color) return;

        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, color, newColor);
        dfs(image, sr + 1, sc, color, newColor);
        dfs(image, sr, sc - 1, color, newColor);
        dfs(image, sr, sc + 1, color, newColor);
    }
}