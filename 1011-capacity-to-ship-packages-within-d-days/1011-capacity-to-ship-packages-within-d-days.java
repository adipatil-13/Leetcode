class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = -1, total = 0;

        for (int weight : weights) {
            max = Math.max(max, weight);
            total += weight;
        }

        int left = max, right = total;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int numberOfDays = 1, load = 0;

            for (int weight : weights) {
                if (load + weight > mid) {
                    numberOfDays++;
                    load = 0;
                }
                load += weight;
            }

            if (numberOfDays > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}