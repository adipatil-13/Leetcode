class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] res = new int[2];
        int k = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            int x = freq.getOrDefault(num, 0) + 1;
            freq.put(num, x);
            if (x == 2) res[k++] = num;
        }
        return res;
    }
}