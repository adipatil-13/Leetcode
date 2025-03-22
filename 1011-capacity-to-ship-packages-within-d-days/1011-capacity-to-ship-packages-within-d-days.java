class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < weights.length; i++){
            high += weights[i];
            low = Math.max(low, weights[i]);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int numberOfDays = noOfDays(weights, mid);
            if (numberOfDays <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private int noOfDays(int[] weights, int capacity) {
        int days = 1, load = 0;

        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > capacity) {
                days++;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }
        return days;
    }
}