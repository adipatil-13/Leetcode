public class Solution {
    public int findLHS(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                int currLen = map.get(num) + map.get(num + 1);
                res = Math.max(res, currLen);
            }
        }
        return res;
    }
}

// class Solution {
//     public int findLHS(int[] nums) {
//         int left = 0, res = 0;
//         Arrays.sort(nums);

//         for (int right = 0; right < nums.length; right++) {
//             while (nums[right] - nums[left] > 1) {
//                 left++;
//             }
//             if (nums[right] - nums[left] == 1) {
//                 res = Math.max(res, right - left + 1);
//             }
//         }
//         return res;
//     }
// }