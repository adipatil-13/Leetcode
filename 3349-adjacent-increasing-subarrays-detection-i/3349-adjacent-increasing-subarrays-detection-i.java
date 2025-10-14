class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        List<Integer> list = new ArrayList<>();
        int cnt = 1;
        if (nums.size() >= 2 * k) {
            for (int i = 1; i < nums.size(); i++) {
                if (nums.get(i) > nums.get(i - 1)) {
                    cnt++;
                    if (cnt >= 2 * k) return true;
                } else {
                    cnt = 1;
                }
            }
        }
        for (int i = 0; i <= nums.size() - k; i++) {
            boolean isInc = true;

            for (int j = i; j < i + k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    isInc = false;
                    break;
                }
            }
            if (isInc) list.add(i);
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) == k) return true;
        }
        return false;
    }
}