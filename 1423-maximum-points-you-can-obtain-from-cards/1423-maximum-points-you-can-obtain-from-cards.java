class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int leftSum = 0, rightSum = 0;
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        if (k == n) return leftSum;
        maxSum = leftSum;

        for (int i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[n + i - k];
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return maxSum;
    }
}