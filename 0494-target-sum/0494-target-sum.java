class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> res = new HashMap<>();
        res.put(0, 1);

        for (int x : nums) {
            Map<Integer, Integer> temp = new HashMap<>();

            for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
                int total = entry.getKey();
                int cnt = entry.getValue();

                temp.put(total + x, temp.getOrDefault(total + x, 0) + cnt);
                temp.put(total - x, temp.getOrDefault(total - x, 0) + cnt);
            }
            res = temp;
        }
        return res.getOrDefault(target, 0);
    }
}