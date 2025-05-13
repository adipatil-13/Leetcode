class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // O(n), O(1)
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
           // O(n), O(n)
//         int n = nums.length;
//         List<Integer> res = new ArrayList<>();
//         Map<Integer, Integer> map = new HashMap<>();

//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         for (int i = 1; i <= n; i++) {
//             if (!map.containsKey(i)) {
//                 res.add(i);
//             }
//         }
//         return res;
//     }
// }