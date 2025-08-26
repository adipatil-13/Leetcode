class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int res = 0;
        int maxDiagonal = Integer.MIN_VALUE;

        for (int[] dim : dimensions) {
            int diagonal = dim[0] * dim[0] + dim[1] * dim[1];
            int area = dim[0] * dim[1];
            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                res = area;
            } else if (diagonal == maxDiagonal) {
                res = Math.max(res, area);
            }
        }
        return res;
    }
}