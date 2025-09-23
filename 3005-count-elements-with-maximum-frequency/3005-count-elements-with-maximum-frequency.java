class Solution {
    public int maxFrequencyElements(int[] nums) {
        int res = 0, maxFreq = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            int f = freq.getOrDefault(num, 0) + 1;
            freq.put(num, f);
            maxFreq = Math.max(maxFreq, f);
        }
        for (int val : freq.values()) {
            if (val == maxFreq) res += val;
        }
        return res;
    }
}