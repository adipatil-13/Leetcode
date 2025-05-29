class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, translate(num, mapping));
            }
        }

        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        numsList.sort(Comparator.comparingInt(map::get));

        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsList.get(i);
        }

        return nums;
    }
    private int translate(int num, int[] mapping) {
        if (num == 0) return mapping[0];

        int res = 0;
        int curr = 1;

        while (num > 0) {
            int d = num % 10;
            num /= 10;
            res += mapping[d] * curr;
            curr *= 10;
        }
        return res;
    }
}