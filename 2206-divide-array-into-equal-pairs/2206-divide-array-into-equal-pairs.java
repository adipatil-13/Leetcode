class Solution {
    public boolean divideArray(int[] nums) {
        //O(n), O(1)
        int[] freq = new int[501];

        for (int num : nums) {
            freq[num]++;
        }

        for (int cnt : freq) {
            if (cnt % 2 != 0) return false;
        }
        return true;
    }
}