// O(mn * q), O(mn)
class NumMatrix {
    private int[][] matSum;
    private int rows, cols;

    public NumMatrix(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;

        matSum = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++){
            for (int j = 1; j <= cols; j++) {
                matSum[i][j] = matSum[i - 1][j] + matSum[i][j - 1] - matSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matSum[row2 + 1][col2 + 1] - matSum[row1][col2 + 1] - matSum[row2 + 1][col1] + matSum[row1][col1];
    }
}