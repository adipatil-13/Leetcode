class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        if (val > n) return -1;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        int low = min, high = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean isPossible(int[] bloomDay, int day, int m, int k) {
        int count= 0, noOfBouquets = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                count++;
                if (count == k) {
                    noOfBouquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }
            if (noOfBouquets >= m) {
                return true;
            }
        }
        return noOfBouquets >= m;
    }
}