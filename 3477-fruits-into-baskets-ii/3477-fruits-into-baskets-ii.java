class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        // find unplaced fruit type which cannot find larger basket capacity
        // O(n^2), O(n)
        int n = fruits.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            boolean placed = false;
            for (int j = 0; j < n; j++) {
                if (baskets[j] != -1 && baskets[j] >= fruits[i]) {
                    placed = true;
                    baskets[j] = -1;
                    break;
                }
            }
            if (!placed) res++;
        }
        return res;
    }
}