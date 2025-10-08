class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        int[] res = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int pivot = binarySearch(potions, spells[i], success);
            if (pivot != -1) res[i] = n - pivot;
        }
        return res;
    }
    private int binarySearch(int[] potions, long power, long success) {
        int low = 0, high = potions.length - 1, idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long)potions[mid] * power >= success) {
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }
}