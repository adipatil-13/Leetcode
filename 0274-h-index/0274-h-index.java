class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (citations[i] > n) {
                arr[n]++;
            } else {
                arr[citations[i]]++;
            }
        }

        int counter = 0;

        for (int i = n; i >= 0; i--) {
            counter += arr[i];
            if (counter >= i) {
                return i;
            }
        }
        return n;
    }
}