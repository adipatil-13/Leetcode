class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            int interval = timeSeries[i + 1] - timeSeries[i];
            cnt += Math.min(duration, interval);
        }
        return cnt + duration;
    }
}