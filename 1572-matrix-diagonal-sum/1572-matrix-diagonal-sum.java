class Solution {
    public int diagonalSum(int[][] mat) {
        int rows = mat.length, res = 0;
        int temp = rows - 1;

        for (int i = 0; i < rows; i++) {
            res += mat[i][i];
            res += mat[i][temp];
            temp--;
        }
        if (rows % 2 != 0) {
            res -= mat[rows / 2][rows / 2];
        }
        return res;
    }
}