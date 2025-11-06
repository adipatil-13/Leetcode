class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] pair = new int[n][2];

        for (int i = 0; i < n; i++) {
            pair[i] = new int[] {i, score[i]};
        }
        Arrays.sort(pair, (a, b) -> b[1] - a[1]);
        String[] res = new String[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[pair[i][0]] = "Gold Medal";
            } else if (i == 1) {
                res[pair[i][0]] = "Silver Medal";
            } else if (i == 2) {
                res[pair[i][0]] = "Bronze Medal";
            } else {
                res[pair[i][0]] = String.valueOf(i + 1);
            }
        }
        return res;
    }
}